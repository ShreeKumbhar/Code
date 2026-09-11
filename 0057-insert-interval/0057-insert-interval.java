class Solution {

    public static int[][] solveMergeInterval(ArrayList<int[]> list){

        ArrayList<int[]> newList = new ArrayList<>();
        Collections.sort(list, (a, b) -> Integer.compare(a[0], b[0]));
        int start1 = list.get(0)[0];
        int end1 = list.get(0)[1];

        for(int i=1; i<list.size(); i++){

            int start2 = list.get(i)[0];
            int end2 = list.get(i)[1];

            if(end1 >= start2){
                end1 = Math.max(end1,end2);
                continue;
            }

            newList.add(new int[]{start1,end1});
            start1 = start2;
            end1 = end2;
        }

        newList.add(new int[]{start1,end1});
        return newList.toArray(new int[newList.size()][]);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        boolean insert = false;
        ArrayList<int[]> list = new ArrayList<>();

        for(int i=0; i<intervals.length; i++){

            int start = intervals[i][0];
            int end = intervals[i][1];

            if(insert==false && start>=newInterval[0]){
                list.add(new int[]{newInterval[0],newInterval[1]});
                insert=true;
            }
            list.add(new int[]{start,end});
        }
        if(insert==false){
            list.add(new int[]{newInterval[0],newInterval[1]});
        }

        return solveMergeInterval(list);
    }
}