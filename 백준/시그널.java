package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 시그널 {
	
	static char[][][] num = {
			{ 	{'#','#','#'},
				{'#','.','#'},
				{'#','.','#'},
				{'#','.','#'},
				{'#','#','#'},	},
			
			{ 	{'#','#','#'},
				{'.','.','#'},
			 	{'#','#','#'},
			 	{'#','.','.'},
			 	{'#','#','#'},	},
			
			{ 	{'#','#','#'},
				{'.','.','#'},
			 	{'#','#','#'},
			 	{'.','.','#'},
			 	{'#','#','#'},	},
			
			{ 	{'#','.','#'},
				{'#','.','#'},
			 	{'#','#','#'},
			 	{'.','.','#'},
			 	{'.','.','#'},	},
			
			{ 	{'#','#','#'},
				{'#','.','.'},
			 	{'#','#','#'},
			 	{'.','.','#'},
			 	{'#','#','#'},	},
			
			{ 	{'#','#','#'},
				{'#','.','.'},
			 	{'#','#','#'},
			 	{'#','.','#'},
			 	{'#','#','#'},	},
			
			{ 	{'#','#','#'},
				{'.','.','#'},
			 	{'.','.','#'},
			 	{'.','.','#'},
			 	{'.','.','#'},	},
			
			{ 	{'#','#','#'},
				{'#','.','#'},
			 	{'#','#','#'},
			 	{'#','.','#'},
			 	{'#','#','#'},	},
			
			{ 	{'#','#','#'},
				{'#','.','#'},
			 	{'#','#','#'},
			 	{'.','.','#'},
			 	{'#','#','#'},	},
			
			{ 	{'#'},
				{'#'},
				{'#'},
				{'#'},
				{'#'},	},
	
	};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String signal = br.readLine();
		int line = N / 5;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < line; i++) {
			if(signal.charAt(i) == '#') {
				for (int j = 0; j < num.length; j++) {
					boolean check = true;
					for (int j2 = 0; j2 < num[j].length; j2++) {
						for (int k = 0; k < num[j][j2].length; k++) {
							if(i + k + j2 * line >= signal.length())
								continue;
							if(num[j][j2][k] != signal.charAt(i + k + j2 * line))
								check = false;
						}
					}
					
					if(check == true) {
						if(j == 0)
							sb.append(j);
						else if(j == 9)
							sb.append(1);
						else
							sb.append(j + 1);
						if(j != 9)
							i += 2;
						break;
					}
				}
			}
		}
		System.out.println(sb.toString());
	}

}
