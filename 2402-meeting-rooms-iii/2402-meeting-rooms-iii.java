class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (m1, m2) -> m1[0] - m2[0]);
        PriorityQueue<int[]> scheduler = new PriorityQueue<>((m1, m2) -> m1[0] == m2[0] ? m1[1] - m2[1] : m1[0] - m2[0]);
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        
        for (int i = 0; i < n; i++) {
            availableRooms.add(i);
        }
        
        int[] roomUsageCount = new int[n];
        
        for (int[] meeting : meetings) {
            int currMeetingStartTime = meeting[0];
            
            while (!scheduler.isEmpty() && currMeetingStartTime >= scheduler.peek()[0]) {
                availableRooms.add(scheduler.remove()[1]);
            }
            
            int delay = 0;
            
            if (availableRooms.size() == 0) {
                int[] endedMeeting = scheduler.remove();
                delay = endedMeeting[0] - currMeetingStartTime;
                availableRooms.add(endedMeeting[1]);
            }
            
            int currMeetingEndTime = meeting[1] + delay;
            int availableRoom = availableRooms.remove();
            scheduler.add(new int[] {currMeetingEndTime, availableRoom});
            roomUsageCount[availableRoom]++;
        }
        
        int maxUsedRoom = 0;
        int maxUsage = 0;
        
        for (int i = 0; i < n; i++) {
            if (roomUsageCount[i] > maxUsage) {
                maxUsage = roomUsageCount[i];
                maxUsedRoom = i;
            }
        }
        
        return maxUsedRoom;
    }
}
