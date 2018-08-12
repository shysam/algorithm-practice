package algorithm.sort.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import algorithm.sort.basis.Operation;

/*

    Created by shysam on 2018/8/12

    合并区间（LeetCode-56：https://leetcode-cn.com/problems/merge-intervals/description/）

    问题：
    给出一个区间的集合，请合并所有重叠的区间。

    示例1：
    输入: [[1,3],[2,6],[8,10],[15,18]]
    输出: [[1,6],[8,10],[15,18]]
    解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6]

    示例2：
    输入: [[1,4],[4,5]]
    输出: [[1,5]]
    解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。

 */
public class P6 extends Operation {

    public static void main(String[] args) {
        Interval one = new Interval(1, 3);
        Interval two = new Interval(2, 6);
        Interval three = new Interval(8, 10);
        Interval four = new Interval(15, 18);
        List<Interval> intervals = new ArrayList<>();
        intervals.add(one);
        intervals.add(two);
        intervals.add(three);
        intervals.add(four);

        List<Interval> merge = merge(intervals);

        System.out.println(merge);
    }

    /**
     * 自己的代码
     *
     * @param intervals
     * @return
     */
    public static List<Interval> merge(List<Interval> intervals) {

        List<Interval> results = new ArrayList<>();

        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start < o2.start) {
                    return -1;
                } else if (o1.start == o2.start) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });

        while (intervals.size() > 0) {
            Iterator<Interval> iterator = intervals.iterator();
            Interval first = intervals.get(0);
            while (iterator.hasNext()) {
                Interval next = iterator.next();
                if (first == next) {
                    iterator.remove();
                    continue;
                }
                if (next.start <= first.end) {
                    if (next.end > first.end) {
                        first.end = next.end;
                    }
                    iterator.remove();
                } else {
                    break;
                }
            }
            results.add(first);
        }

        return results;
    }

    static class Interval {

        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "[" + start + "," + end + "]";
        }
    }

}
