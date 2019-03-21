package array;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utils.ListUtils;

class array_989_add_to_array_form_of_integerTest {

    @Test
    void addToArrayForm() {
        List<Integer> answer1 = Arrays.asList(new Integer[]{1,2,3,4});
        List<Integer> question1 = array_989_add_to_array_form_of_integer.addToArrayForm(new int[]{1,2,0,0},34);
        assert ListUtils.isListEqual(answer1, question1);
    }
}