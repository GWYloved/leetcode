package swordOffer;

import normal_struct.ListNode;

public class Q_06_print_nodelist {
    public static int[] reversePrint(ListNode head) {
        int[] resulttemp = new int[]{};
        ListNode node = head;
        int i = 0;
        while (node.next != null){
            resulttemp[i] = node.val;
            i++;
        }
        int[] result = new int[]{};
        for (int j = 0; j < resulttemp.length; j ++){
            result[j] = resulttemp[resulttemp.length - 1 - j];
        }
        return result;
    }
}
