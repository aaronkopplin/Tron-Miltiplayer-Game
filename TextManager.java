import java.util.ArrayList;

public class TextManager {
    //all letters are 5 X 5
    public TextManager(){ }

    public ArrayList<boolean[][]> makeText(String word){
        if (word.length() == 0){
            return new ArrayList<boolean[][]>();
        }

        ArrayList<boolean[][]> text = new ArrayList<>();
        for (int i = 0; i < word.length(); i++){
            text.add(new Letter(word.charAt(i)).letter);
        }

        return text;
    }

    private class Letter{
        public boolean[][] letter;
        private char name;

        public Letter(char name){
            this.name = name;
            switch (name){
                case 'A':
                    this.letter = A();
                    break;
                case 'T':
                    this.letter = T();
                    break;
                case 'R':
                    this.letter = R();
                    break;
                case ' ':
                    this.letter = space();
                    break;
                case 'O':
                    this.letter = O();
                    break;
                case 'N':
                    this.letter = N();
                    break;
                case 'M':
                    this.letter = M();
                    break;
                case 'E':
                    this.letter = E();
                    break;
                case 'G':
                    this.letter = G();
                    break;
                case 'V':
                    this.letter = V();
                    break;
                case 'P':
                    this.letter = P();
                    break;
                case 'U':
                    this.letter = U();
                    break;
                case 'S':
                    this.letter = S();
                    break;
            }

        }

        private boolean[][] A(){
            return new boolean[][]{
                    {false, true , true , true , false, false},
                    {true , true , false, false, true , false},
                    {true , true , false, false, true , false},
                    {true , true , true , true , true , false},
                    {true , true , false, false, true , false},
                    {true , true , false, false, true , true }
            };
        }

        private boolean[][] T(){
            return new boolean[][]{
                    {true , true , true , true , true , true },
                    {true , false, true , true , false, true },
                    {false, false, true , true , false, false},
                    {false, false, true , true , false, false},
                    {false, false, true , true , false, false},
                    {false, true , true , true , true , false}
            };
        }

        private boolean[][] R(){
            return new boolean[][]{
                    {true , true , true , true , false, false},
                    {false, true , true , false, true , false},
                    {false, true , true , false, true , false},
                    {false, true , true , true , false, false},
                    {false, true , true , false, true , false},
                    {true , true , true , false, true , true }
            };
        }

        private boolean[][] O(){
            return new boolean[][]{
                    {false, true , true , true , true , false},
                    {true , true , false, false, false, true },
                    {true , true , false, false, false, true },
                    {true , true , false, false, false, true },
                    {true , true , false, false, false, true },
                    {false, true , true , true , true , false}
            };
        }

        private boolean[][] N(){
            return new boolean[][]{
                    {true , true , true , false, false, true , true },
                    {false, true , true , true , false, false, true },
                    {false, true , true , true , true , false, true },
                    {false, true , true , false, true , true , true },
                    {false, true , true , false, false, true , true },
                    {true , true , true , false, false, false, true }
            };
        }

        private boolean[][] G(){
            return new boolean[][]{
                    {false, true , true , true , true , false},
                    {true , true , false, false, false, true },
                    {true , true , false, false, false, false},
                    {true , true , false, false, true , true },
                    {true , true , false, false, false, true },
                    {false, true , true , true , true , false}
            };
        }

        private boolean[][] M(){
            return new boolean[][]{
                    {true , true , false, false, false, true },
                    {true , true , true , false, true , true },
                    {true , true , true , true , true , true },
                    {true , true , false, true , false, true },
                    {true , true , false, false, false, true },
                    {true , true , false, false, false, true }
            };
        }

        private boolean[][] E(){
            return new boolean[][]{
                    {true , true , true , true , true , true },
                    {true , true , false, false, false, true },
                    {true , true , false, false, false, false},
                    {true , true , true , true , false, false},
                    {true , true , false, false, false, true },
                    {true , true , true , true , true , true }
            };
        }

        private boolean[][] V(){
            return new boolean[][]{
                    {true , true , false, false, false, true },
                    {false, true , true , false, false, true },
                    {false, true , true , false, false, true },
                    {false, true , true , false, true , false},
                    {false, true , true , false, true , false},
                    {false, false, true , true , false, false}
            };
        }

        private boolean[][] P(){
            return new boolean[][]{
                    {true , true , true , true , true , false},
                    {false, true , true , false, false, true },
                    {false, true , true , false, false, true },
                    {false, true , true , true , true , false},
                    {false, true , true , false, false, false},
                    {true , true , true , false, false, false}
            };
        }

        private boolean[][] U(){
            return new boolean[][]{
                    {true , true , true , false, false, true },
                    {false, true , true , false, false, true },
                    {false, true , true , false, false, true },
                    {false, true , true , false, false, true },
                    {false, true , true , false, false, true },
                    {false, false, true , true , true , false}
            };
        }

        private boolean[][] S(){
            return new boolean[][]{
                    {true , true , true , true , true , true },
                    {true , false, false, false, false, false},
                    {true , true , true , true , true , true },
                    {false, false, false, false, true , true },
                    {false, false, false, false, true , true },
                    {true , true , true , true , true , true }
            };
        }

        private boolean[][] space(){
            return new boolean[][]{
                    {false},
                    {false},
                    {false},
                    {false},
                    {false},
            };
        }

    }
}
