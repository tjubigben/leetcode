package com.bigben.array;

/**
 * 495 <br>
 * 链接：https://leetcode.cn/problems/teemo-attacking/ <br>
 * 在《英雄联盟》的世界中，有一个叫 “提莫” 的英雄。他的攻击可以让敌方英雄艾希（编者注：寒冰射手）进入中毒状态。<br>
 * 当提莫攻击艾希，艾希的中毒状态正好持续 duration 秒。<br>
 * 正式地讲，提莫在 t 发起发起攻击意味着艾希在时间区间 [t, t + duration - 1]（含 t 和 t + duration - 1）处于中毒状态。
 * 如果提莫在中毒影响结束 前 再次攻击，中毒状态计时器将会 重置 ，在新的攻击之后，中毒影响将会在 duration 秒后结束。 <br>
 * 给你一个 非递减 的整数数组 timeSeries ，其中 timeSeries[i] 表示提莫在 timeSeries[i] 秒时对艾希发起攻击，以及一个表示中毒持续时间的整数 duration 。 <br>
 * 返回艾希处于中毒状态的 总 秒数 <br>
 *
 * @author bigben
 */
public class FindPoisonedDuration {
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int poisonedDurationTime = 0;
        int expiredPoisonedDurationTime = 0;
        for (int time : timeSeries) {
            if (time > expiredPoisonedDurationTime) {
                poisonedDurationTime += duration;
            } else {
                poisonedDurationTime += time + duration - expiredPoisonedDurationTime;
            }
            expiredPoisonedDurationTime = time + duration;
        }
        return poisonedDurationTime;
    }

    public static void main(String[] args) {
        int[] timeSeries = new int[]{3, 6};
        int result = findPoisonedDuration(timeSeries, 7);
        System.out.println(result);
    }
}
