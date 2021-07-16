import java.util.*;



import java.io.*;

public class Main {
    // 21942, 부품 대여장
    // 
    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String,Long> products = new HashMap<String,Long>();// 물품의 대여 시점을 기록 
        HashMap<String,Long> people = new HashMap<String,Long>();//벌금을 기록 
        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int l = Integer.parseInt(in[1].substring(0,3))*24*60+Integer.parseInt(in[1].substring(4,6))*60+Integer.parseInt(in[1].substring(7));
        int f = Integer.parseInt(in[2]);//벌금
        
        PriorityQueue<String> answer = new PriorityQueue<String>();

        while(n!=0){
            in = br.readLine().split(" ");
            String[] date = in[0].split("\\-");
            String[] times = in[1].split("\\:");
            String product = in[2];
            String person = in[3];
            int month = Integer.parseInt(date[1]);
            int day = Integer.parseInt(date[2]);
            int hour = Integer.parseInt(times[0]);
            int min = Integer.parseInt(times[1]);
            long minutes =  convert(month,day,hour,min);
            product = product +" "+ person;            
            if(!people.containsKey(person)){
                people.put(person,(long)0);
                answer.add(person);
            }


            if(products.containsKey(product)){//대여했었다면 
                long time = minutes-products.get(product); // 지난 시간 
                if(time>l){//대여시간을 넘었다면
                    people.put(person,people.get(person)+(long)(time-l)*f);
                }
                products.remove(product);//물품 목록에서 삭제함 
            }
            else{//대여하지 않았다면
                products.put(product,minutes);//기록해둠 
            }
            n--;
        }

        StringBuilder sb = new StringBuilder();
        while(!answer.isEmpty()){
            String person = answer.poll();
            if(people.get(person)!=0){//벌금이 0이 아니라면 
                sb.append(person+" "+people.get(person)+"\n");
            }
        }
        if(sb.length()==0){
            sb.append(-1+"\n");
        }
        System.out.printf(sb.toString());

    }
    static long convert(int month,int day, int hour, int min){//날짜를 분단위로 변환 
        
        long months[] = {0,31,28,31,30,31,30,31,31,30,31,30,31};//월별 일수 
        long month_min = 0;
        for(int i=0;i<month;i++){
            month_min += months[i]*24*60;
        }
        
        return month_min+(day-1)*24*60+(hour-1)*60+min;
    }   
}