package com.bartek.coursera.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GreedyJobsSolver {

    /**
     * In this programming problem and the next you'll code up the greedy algorithms from lecture for minimizing the weighted sum of completion times..
     * //
     * //    Download the text file below.
     * //
     * //            jobs.txt
     * //    This file describes a set of jobs with positive and integral weights and lengths. It has the format
     * //
     * //[number_of_jobs]
     * //
     * //            [job_1_weight] [job_1_length]
     * //
     * //            [job_2_weight] [job_2_length]
     * //
     * //            ...
     * //
     * //    For example, the third line of the file is "74 59", indicating that the second job has weight 74 and length 59.
     * //
     * //    You should NOT assume that edge weights or lengths are distinct.
     * //
     * //    Your task in this problem is to run the greedy algorithm that schedules jobs in decreasing order of the difference (weight - length).
     * // Recall from lecture that this algorithm is not always optimal. IMPORTANT: if two jobs have equal difference (weight - length), you should schedule the job with higher weight first. Beware: if you break ties in a different way, you are likely to get the wrong answer. You should report the sum of weighted completion times of the resulting schedule --- a positive integer --- in the box below.
     * //
     * //    ADVICE: If you get the wrong answer, try out some small test cases to debug your algorithm (and post your test cases to the discussion forum).
     */
    public static long calculateJobsTimeSumForSubstracting(List<Job> input) {

        return calculateJobsTime(new ArrayList(input), (o1, o2) -> {
            double score1 = o1.weight - o1.length;
            double score2 = o2.weight - o2.length;

            if (score1 == score2) {
                return (int) (o2.weight - o1.weight);
            }

            return (int) (score2 - score1);
        });
    }


    /**
     * For this problem, use the same data set as in the previous problem.
     * <p>
     * Your task now is to run the greedy algorithm that schedules jobs (optimally)
     * in decreasing order of the ratio (weight/length). In this algorithm, it does not matter
     * how you break ties. You should report the sum of weighted completion times of the
     * resulting schedule --- a positive integer --- in the box below.
     */
    public static long calculateJobsTimeSumForRatio(List<Job> input) {
        return calculateJobsTime(new ArrayList(input), (o1, o2) ->
                (int)Math.floor(o2.ratio - o1.ratio)
        );
    }

    private static long calculateJobsTime(List<Job> input, Comparator<Job> ordering) {
        input.sort(ordering);

        long totalSum = 0;
        long totalLenght = 0;
        for (Job job : input) {
            totalLenght += job.length;
            totalSum += totalLenght * job.weight;
        }

        return totalSum;
    }
}
