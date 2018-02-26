
public class KI {
    public static int difficulty ;
    public static int einfStellex;
    public static int steinEinfügen(char[][] ki_feld, int amZug)
    {

        switch(difficulty)
        {
            case 1:
                for(int i = 5; i>= 1; i--)//senkrecht auf eigenen Stein
                {

                    for(int j = 0; j<7; j++)
                    {
                        if(i >2) {
                            if (ki_feld[i][j] == '@' && ki_feld[i - 1][j] == 'O') {
                                einfStellex = j;
                                return einfStellex;
                            }
                        }
                    }
                }
                for(int i = 5; i>= 0; i--) //wagerecht neben eigenen Stein
                {

                    for(int j = 0; j<7; j++)
                    {
                            if(ki_feld[i][j] == '@' && j>0 && ki_feld[i][j-1] == 'O' ) // links neben eigenen Stein
                            {
                                int help_j = j - 1;
                                int help_i = i;

                                if(i == 5)
                                {
                                    einfStellex = j-1;
                                    return einfStellex;
                                }

                                else if(help_i < 5)
                                {
                                    if(ki_feld[help_i+1][help_j] == 'X' || ki_feld[help_i+1][help_j] == '@')
                                    {
                                        einfStellex = j-1;
                                        return einfStellex;
                                    }
                                }

                            }
                            else if(ki_feld[i][j] == '@' && j<6&& ki_feld[i][j+1] == 'O') // rechts neben eigenen Stein
                            {
                                int help_j_ = j + 1;
                                int help_i_ = i;
                                if(i == 5)
                                {
                                    einfStellex = j+1;
                                    return einfStellex;
                                }
                                else  if(help_i_ < 5)
                                {
                                    if(ki_feld[help_i_ +1][help_j_] == 'X' || ki_feld[help_i_+1][help_j_] == '@')
                                    {
                                        einfStellex = j+1;
                                        return einfStellex;
                                    }
                                }
                            }
                    }
                }

                einfStellex = (int)((Math.random()) * 7 + 1)-1;
                break;
            case 2:

                if(amZug == 1)
                {
                    amZug = 2;
                }
                if(kannGewinnen(ki_feld) == true)
                {
                    einfStellex = Gewinn.getPosxGewinn();
                    return einfStellex;
                }
                if(amZug == 2)
                {
                    amZug = 1;
                }
                else if(Spieler.kannGewinnen(ki_feld, amZug)== true)
                {
                    einfStellex = Gewinn.getPosxGewinn();
                    return einfStellex;
                }

                einfStellex = (int)((Math.random()) * 7 + 1)-1;

                break;
            case 3: break;
            case 4:
                einfStellex = (int)((Math.random()) * 7 + 1)-1;
              break;

        }
        return einfStellex;
    }

    public static boolean kannGewinnen(char[][] ki_feld)
    {
        boolean ki_gewinn = false;


        return ki_gewinn;

    }
    public static void setDifficulty(int dif)
    {
        difficulty = dif;
    }
}
