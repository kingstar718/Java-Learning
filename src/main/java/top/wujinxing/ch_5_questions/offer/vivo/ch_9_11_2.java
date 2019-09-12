package top.wujinxing.ch_5_questions.offer.vivo;
import java.io.*;
import java.util.*;

/**
 * @author wujinxing
 * date 2019 2019/9/11 16:14
 * description
 *
 * 同一个应用程序不能再服务器上部署多个
 * 输入：磁盘大小、内存大小、应用程序列表
 * 所需磁盘空间，内存，允许访问的用户量
 * 15 10 5,1,1000#2,3,3000#5,2,15000#10,4,16000
 * 输出 单台服务器能承载的最大用户数
 * 31000
 */

public class ch_9_11_2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        String[] input = inputStr.split(" ");
        int totalDisk = Integer.parseInt(input[0]);
        int totalMemory = Integer.parseInt(input[1]);
        List<Service> services = parseServices(input[2].split("#"));
        int output = solution(totalDisk, totalMemory, services);
        System.out.println(output);
    }

    private static int solution(int totalDisk, int totalMemory, List<Service> services) {
        Iterator<Service> iterator = services.iterator();
        while (iterator.hasNext()){
            if (iterator.next().disk >totalDisk || iterator.next().memory > totalMemory)
                services.remove(iterator.next());
        }
        if (services.size() == 0)
            return 0;
        int[] dp = new int[services.size()];
        for (int i=0; i<services.size(); i++){
            
        }
        // TODO Write your code here

        return -1;
    }

    private static List<Service> parseServices(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new ArrayList<Service>(0);
        }
        List<Service> services = new ArrayList<>(strArr.length);
        for (int i = 0; i < strArr.length; i++) {
            String[] serviceArr = strArr[i].split(",");
            int disk = Integer.parseInt(serviceArr[0]);
            int memory = Integer.parseInt(serviceArr[1]);
            int users = Integer.parseInt(serviceArr[2]);
            services.add(new Service(disk, memory, users));
        }
        return services;
    }

    static class Service {
        private int disk;

        private int memory;

        private int users;

        public Service(int disk, int memory, int users) {
            this.disk = disk;
            this.memory = memory;
            this.users = users;
        }

        public int getDisk() {
            return disk;
        }

        public void setDisk(int disk) {
            this.disk = disk;
        }

        public int getMemory() {
            return memory;
        }

        public void setMemory(int memory) {
            this.memory = memory;
        }

        public int getusers() {
            return users;
        }

        public void setusers(int users) {
            this.users = users;
        }
    }
}