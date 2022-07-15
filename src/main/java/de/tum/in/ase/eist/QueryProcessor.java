package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
            return "Oliver";
        }
        else if (query.contains("plus")) {
            String[] nums = query.split("plus");
            try {
                int num = Integer.parseInt(nums[1]) + Integer.parseInt(nums[0]);
                return Integer.toString(num);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            return "";
        } else if (query.contains("largest")) {
            String subString = query.split(":")[1];
            String[] nums = subString.split(",");
            int max = Integer.parseInt(nums[0]);
            try{
                for (String num :
                        nums) {
                    if (Integer.parseInt(num) > max) {
                        max = Integer.parseInt(num);
                    }
                }
                return Integer.toString(max);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return "";
            }

        } else { // TODO extend the programm here
            return "";
        }
    }
}
