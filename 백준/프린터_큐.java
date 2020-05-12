package 백준;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 프린터_큐 {
    static class Printer {
        int index;
        int priority;
        Printer(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt(); // 문서의 수
            int M = sc.nextInt();// 현재 위치
            Queue<Printer> que = new LinkedList<Printer>();
            Printer print;
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                print = new Printer(i, sc.nextInt());
                arr[i] = print.priority;
                que.add(print);
            }

            
            int p = arr[M]; // 궁금한 문서의 우선순위
            int cnt = 0;// 우선순위가 높은 것들의 갯수
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > p)
                    cnt++;
            }

            int count = 0;
            while (true) {
                print = que.poll();
                
                boolean flag = false; 
                for (Printer tmp : que) {
                	if(tmp.priority > print.priority)
                		flag = true;
				}
                if(flag) {
                	que.add(print);
                }
                else if (!flag && print.priority > p) {
                    count++;
                    cnt--;
                } else if (print.priority < p) {
                    que.add(print);
                } else if (print.priority == p && cnt == 0) {
                    if (print.index == M) {
                        count++;
                        System.out.println(count);
                        break;
                    } else if (print.index != M) {
                        count++;
                    }
                } else if (print.priority == p && cnt > 0) {
                    que.add(print);
                }
             
            }
         
        }
    }
}
