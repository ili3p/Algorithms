package my.codefu.y10.winter;
import java.util.Arrays;

public class SkiJumpingScore{
  public int calculate(int k, int jump, int[] styles) {
int jPTS=0;
if(jump > k)
{ jPTS = 60 + 2*(jump-k);
}else
{jPTS = 60 - (k-jump);
}
int sPTS =0;
Arrays.sort(styles);

  for(int i=1;i<4;++i)
  {sPTS+=styles[i];
   }
  int totalPTS = sPTS + jPTS;
 return totalPTS;
  }
}