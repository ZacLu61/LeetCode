import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MaximumProfitInJobScheduling {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profits) {
        return findMaxJobProfitWithDpAndRecursion(startTime, endTime, profits);
        // return findMaxJobProfitWithDpAndBinarySearch(startTime, endTime, profits);
    }

    private int findMaxJobProfitWithDpAndRecursion(int[] startTime, int[] endTime, int[] profits) {
        int len = startTime.length;

        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < len; ++i) {
            jobs.add(new Job(startTime[i], endTime[i], profits[i]));
        }
        // Ascending sorted with end time, if end time is same, descending sorted with profit.
        Collections.sort(jobs, (job1, job2) -> {
            if (job1.end == job2.end) {
                return job2.profit - job1.profit;
            }
            return job1.end - job2.end;
        });

        int[] dp = new int[len];
        return findMaxProfit(jobs, 0, dp);
    }

    private int findMaxProfit(List<Job> jobs, int startIndex, int[] dp) {
        // Over the end
        if (startIndex >= jobs.size()) {
            return 0;
        }
        // Found
        if (dp[startIndex] != 0) {
            return dp[startIndex];
        }
        // Find next job closest to job[startIndex]
        int nextIndex = startIndex + 1;
        while (nextIndex < jobs.size() && jobs.get(startIndex).end > jobs.get(nextIndex).start) {
            nextIndex++;
        }
        // Update dp
        dp[startIndex] = Math.max(
            findMaxProfit(jobs, nextIndex, dp) + jobs.get(startIndex).profit,
            findMaxProfit(jobs, startIndex + 1, dp));
        return dp[startIndex];
    }

    private int findMaxJobProfitWithDpAndBinarySearch(int[] startTime, int[] endTime, int[] profits) {
        int len = startTime.length;
        // Create Job list and ascending sorted bu end time.
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < len; ++i) {
            jobs.add(new Job(startTime[i], endTime[i], profits[i]));
        }
        Collections.sort(jobs, (job1, job2) -> {
            return job1.end - job2.end;
        });

        int[] dp = new int[len + 1];

        for (int i = 1; i <= len; ++i) {
            Job job = jobs.get(i - 1);
            dp[i] = Math.max(dp[i - 1], job.profit);

            // binary search closest job[mid]
            // whose end time is early the job[i].start
            int left = 0, right = i - 1, mid = 0;
            while (left < right) {
                mid = (left + right) / 2;
                if (jobs.get(mid).end <= job.start) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            if (jobs.get(left).end <= job.start) {
                dp[i] = Math.max(dp[i], dp[right + 1] + job.profit);
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        MaximumProfitInJobScheduling solution = new MaximumProfitInJobScheduling();

        // Test 1
        int[] startTime = {1, 2, 3, 3};
        int[] endTime = {3, 4, 5, 6};
        int[] profits = {50, 10, 40, 70};

        long systemStartTime = System.currentTimeMillis();
        System.out.println(solution.jobScheduling(startTime, endTime, profits));
        long systemEndTime = System.currentTimeMillis();
        System.out.println("Total time: " + (systemEndTime - systemStartTime) + " ms");
    }
}


class Job {
    int start;
    int end;
    int profit;

    public Job(int start, int end, int profit) {
        this.start = start;
        this.end = end;
        this.profit = profit;
    }

    @Override
    public String toString() {
        return "start:" + start + ", end:" + end + ", profit:" + profit;
    }
}
