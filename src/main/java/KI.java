import java.util.Scanner;

public class KI {
    public static int difficulty ;
    public static int einf_stellex;
    public static int einf_stelley;
    public static int KI_stein_einfügen(char[][] KI_feld)
    {

        switch(difficulty)
        {
            case 1:
                for(int i = 5; i>= 1; i--)//senkrecht auf eigenen Stein
                {

                    for(int j = 0; j<7; j++)
                    {
                        if(i >2) {
                            if (KI_feld[i][j] == '@' && KI_feld[i - 1][j] == 'O') {
                                einf_stellex = j;
                                return einf_stellex;
                            }
                        }
                    }
                }
                for(int i = 5; i>= 0; i--) //wagerecht neben eigenen Stein
                {

                    for(int j = 0; j<7; j++)
                    {
                            if(KI_feld[i][j] == '@' && KI_feld[i][j-1] == 'O'&& j>0 ) // links neben eigenen Stein
                            {
                                int help_j = j - 1;
                                int help_i = i;

                                if(i == 5)
                                {
                                    einf_stellex = j-1;
                                    return einf_stellex;
                                }

                                while(help_i>5)
                                {
                                    if(KI_feld[help_i+1][help_j] == 'X' || KI_feld[help_i+1][help_j] == '@')
                                    {
                                        einf_stellex = j-1;
                                        return einf_stellex;
                                    }
                                }

                            }
                            else if(KI_feld[i][j] == '@' && KI_feld[i][j+1] == 'O') // rechts neben eigenen Stein
                            {
                                int help_j_ = j + 1;
                                int help_i_ = i;
                                if(i == 5)
                                {
                                    einf_stellex = j+1;
                                    return einf_stellex;
                                }
                                while(help_i_>5)
                                {
                                    if(KI_feld[help_i_ +1][help_j_] == 'X' || KI_feld[help_i_+1][help_j_] == '@')
                                    {
                                        einf_stellex = j+1;
                                        return einf_stellex;
                                    }
                                }
                            }
                    }
                }

                einf_stellex = (int)((Math.random()) * 7 + 1)-1;
                break;
            case 2: break;
            case 3: break;
            case 4:
                einf_stellex = (int)((Math.random()) * 7 + 1)-1;
              break;

        }
        return einf_stellex;
    }
    public static int getEinf_stellex()
    {
        return einf_stellex;
    }
    public static int getEinf_stelley()
    {
        return einf_stelley;
    }
    public static void setDifficulty(int dif)
    {
        difficulty = dif;
    }
}
