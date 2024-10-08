package br.pucrs;

public class MergeSort {
    
    public static ArrayList<Integer> mergeSort(ArrayList<Integer> array) {
        long startTime = System.nanoTime();

        recursionCount++;
        if (array.size() <= 1) {
            return array;
        }

        int middle = array.size() / 2;
        ArrayList<Integer> left = new ArrayList<>(array.subList(0, middle));
        ArrayList<Integer> right = new ArrayList<>(array.subList(middle, array.size()));

        left = mergeSort(left);
        right = mergeSort(right);

        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }
        while (i < left.size()) {
            result.add(left.get(i));
            i++;
        }
        while (j < right.size()) {
            result.add(right.get(j));
            j++;
        }

        long endTime = System.nanoTime();

        time += (endTime - startTime);

        return result;
    }
}
