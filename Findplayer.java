package eg.edu.alexu.csd.datastructure.iceHockey;

public class Findplayer {
	   public  java.awt.Point[] findPlayers(String[] photo, int team, int threshold) {
	        int n = photo.length;
	        int m = photo[0].length();
	        char ess = (char) (team + 48);
	        int counterForPlayers = 0;
	        java.awt.Point[] players = new java.awt.Point[n * m];
	        char[][] arr = new char[n][m];
	        char[][] temp = new char[n][m];
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < m; j++) {
	                arr[i][j] = ' ';
	                temp[i][j] = ' ';
	            }
	        }
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < m; j++) {
	                if (photo[i].charAt(j) == ess) {
	                    arr[i][j] = photo[i].charAt(j);
	                }
	            }
	        }
	        boolean isCorrupt = true ;
	        for(int y= 0 ; y<n;y++){
	            for(int t = 0 ; t<m;t++){
	                if(arr[y][t]==ess)
	                    isCorrupt=false;
	            }
	        }
	        if(isCorrupt){
	            java.awt.Point[] mohamed = new java.awt.Point[1] ;
	            return mohamed ;
	        }
	        int i = 0, j = 0;
	        while (true && i < n && j < m) {
	            boolean isFound = false;
	            for (i = i; i < n; i++) {
	                for (j = j; j < m; j++) {
	                    if (arr[i][j] == ess) {
	                        isFound = true;
	                        temp[i][j] = ess;
	                        if (i != n - 1) {
	                            if (arr[i + 1][j] == ess)
	                                temp[i + 1][j] = ess;
	                        }
	                        if (j != m - 1) {
	                            if (arr[i][j + 1] == ess)
	                                temp[i][j + 1] = ess;
	                        }
	                        if (i != 0) {
	                            if (arr[i - 1][j] == ess)
	                                temp[i - 1][j] = ess;
	                        }
	                        if (j != 0) {
	                            if (arr[i][j - 1] == ess)
	                                temp[i][j - 1] = ess;
	                        }
	                        arr[i][j] = ' ';
	                    }
	                    if (isFound)
	                        break;
	                }
	                if (isFound)
	                    break;
	                if (j == m)
	                    j = 0;
	            }
	            boolean isHere = false;
	            for (int i1 = 0; i1 < n; i1++) {
	                for (int j1 = 0; j1 < m; j1++) {
	                    if (temp[i1][j1] == ess && arr[i1][j1] == ess) {
	                        isHere = true;
	                        i = i1;
	                        j = j1;
	                        break;
	                    }
	                    if (isHere)
	                        break;
	                }
	                if (isHere)
	                    break;
	            }
	            if (isHere == false) {
	                int counter = 0;
	                for (int i1 = 0; i1 < n; i1++) {
	                    for (int j1 = 0; j1 < m; j1++) {
	                        if (temp[i1][j1] == ess)
	                            counter++;
	                    }
	                }
	                if (counter * 4 >= threshold) {
	                    int[] saveI = new int[2];
	                    int[] saveJ = new int[2];
	                    int counter2 = 0;
	                    for (int i1 = 0; i1 < n; i1++) {
	                        for (int j1 = 0; j1 < m; j1++) {
	                            if (temp[i1][j1] == ess && counter2 == 0) {
	                                saveI[0] = i1;
	                                counter2++;
	                            }
	                            if (temp[i1][j1] == ess)
	                                saveI[1] = i1;
	                        }
	                    }
	                    counter2 = 0;
	                    for (int j1 = 0; j1 < m; j1++) {
	                        for (int i1 = 0; i1 < n; i1++) {
	                            if (temp[i1][j1] == ess && counter2 == 0) {
	                                saveJ[0] = j1;
	                                counter2++;
	                            }
	                            if (temp[i1][j1] == ess)
	                                saveJ[1] = j1;
	                        }
	                    }
	                    int[] borders = new int[4];
	                    borders[0] = 2 * saveI[0];
	                    borders[1] = 2 * saveJ[0];
	                    borders[2] = 2 * saveI[1] + 2;
	                    borders[3] = 2 * saveJ[1] + 2;
	                    int w = borders[1] + (borders[3] - borders[1]) / 2;
	                    int z = borders[0] + (borders[2] - borders[0]) / 2;
	                    java.awt.Point ahmed = new java.awt.Point(w, z);
	                    players[counterForPlayers] = ahmed;
	                    for (int i1 = 0; i1 < n; i1++) {
	                        for (int j1 = 0; j1 < m; j1++) {
	                            temp[i1][j1] = ' ';
	                        }
	                    }
	                    i = 0;
	                    j = 0;
	                    counterForPlayers++;
	                }
	                if (counter * 4 < threshold) {
	                    for (int i1 = 0; i1 < n; i1++) {
	                        for (int j1 = 0; j1 < m; j1++) {
	                            temp[i1][j1] = ' ';
	                        }
	                    }
	                    i = 0;
	                    j = 0;
	                }
	            }
	            boolean isEmpty = true;
	            for (int i1 = 0; i1 < n; i1++) {
	                for (int j1 = 0; j1 < m; j1++) {
	                    if (arr[i1][j1] == ess) {
	                        isEmpty = false;
	                    }
	                }
	            }
	            if (isEmpty)
	                break;
	        }
	        java.awt.Point[] final1 = new java.awt.Point[counterForPlayers];
	        for (int i1 = 0; i1 < counterForPlayers; i1++) {
	            final1[i1] = players[i1];
	        }
	        for(int i2 = 0 ; i2<counterForPlayers;i2++){
	            for(int j2 = 0 ; j2-1 <counterForPlayers ; j2++){
	                if(final1[j2].x>final1[j2+1].x){
	                    java.awt.Point okay = final1[j2];
	                    final1[j2]=final1[j2+1];
	                    final1[j2+1]=okay;
	                }
	            }
	        }
	        return final1;
	    }
	}