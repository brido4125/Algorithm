import std;

void main()
{
    string line;
    int answer = 0;
    int[2] sz = to!(int[])(readln().strip.split);
    int[3] vac = to!(int[])(readln().strip.split);
    int[][] room;
    while ((line = readln()) !is null) {
        room ~= to!(int[])(line.strip.split);
    }
    while (true) {
        if (!room[vac[0]][vac[1]]) {
            answer -= (room[vac[0]][vac[1]] = -1);
        }
        if (room[vac[0] + 1][vac[1]] && room[vac[0] - 1][vac[1]]
         && room[vac[0]][vac[1] + 1] && room[vac[0]][vac[1] - 1]) {
            auto d = [((vac[2] + 1) % 2) * (-(vac[2] > 1) * 2 + 1),
                      (-vac[2] % 2) * (-(vac[2] > 1) * 2 + 1), 0];
            vac = vac[] + d[];
			if (room[vac[0]][vac[1]] > 0) break;
		}
		else {
			vac[2] = (vac[2] + 3) % 4;
            auto d = [-((vac[2] + 1) % 2) * (-(vac[2] > 1) * 2 + 1),
                      -(-vac[2] % 2) * (-(vac[2] > 1) * 2 + 1), 0];
            int[3] temp = vac[] + d[];
			if (!room[temp[0]][temp[1]]) {
				vac = temp;
			}
		}
    }
    writeln(answer);
}
