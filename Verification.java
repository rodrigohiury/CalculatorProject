import java.util.ArrayList;
import java.util.List;

public class Verification{
  private boolean priority4; //Parentesis
  private boolean priority3; //Abs[] or √ or ^
  private boolean priority2; //* or /
  private boolean priority1; //+ or -
  private boolean valid;
  private int firstPriority1;
  private int firstPriority2;
  private int firstPriority3;
  private int firstPriority4;
  private List<Integer> numbers = new ArrayList<>();
  private List<BracketsPairs> parentesis = new ArrayList<>();
  private List<BracketsPairs> brackets = new ArrayList<>();


  public boolean gotPriority4(){
    return this.priority4;
  }

  public boolean gotPriority3(){
    return this.priority3;
  }

  public boolean gotPriority2(){
    return this.priority2;
  }

  public boolean gotPriority1(){
    return this.priority1;
  }

  public boolean isValid(){
    return this.valid;
  }

  public int getFirstPriority1(){
    return this.firstPriority1;
  }

  public int getFirstPriority2() {
    return firstPriority2;
  }

  public int getFirstPriority3() {
    return firstPriority3;
  }

  public int getFirstPriority4() {
    return firstPriority4;
  }

  public int getNumbersSize(){
    return this.numbers.size();
  }

  public int getNumbersAmount(){
    return this.numbers.size()/2;
  }

  public List<BracketsPairs> getParentesis() {
    return parentesis;
  }

  public List<BracketsPairs> getPipes() {
    return brackets;
  }

  public List<Integer> getNumbers() {
    return numbers;
  }

  public void setParentesis(List<BracketsPairs> parentesis) {
    this.parentesis = parentesis;
  }

  public void setPipes(List<BracketsPairs> brackets) {
    this.brackets = brackets;
  }

  public void setPriority4(boolean value){
    this.priority4 = value;
  }

  public void setPriority3(boolean value){
    this.priority3 = value;
  }

  public void setPriority2(boolean value){
    this.priority2 = value;
  }

  public void setPriority1(boolean value){
    this.priority1 = value;
  }

  public void setValid(boolean value){
    this.valid = value;
  }

  public void setFirstPriority1(int value){
    this.firstPriority1 = value;
  }

  public void setFirstPriority2(int firstPriority2) {
    this.firstPriority2 = firstPriority2;
  }

  public void setFirstPriority3(int firstPriority3) {
    this.firstPriority3 = firstPriority3;
  }

  public void setFirstPriority4(int firstPriority4) {
    this.firstPriority4 = firstPriority4;
  }

  public void addNumber(int b, int e){
    this.numbers.add(b);
    this.numbers.add(e);
  }

  public void addNumberPosition(int p){
    this.numbers.add(p);
  }

  public void removeLastNumber(){
    int lastNumberEnd = this.getNumbersSize()-1;
    int lastNumberBegginning = lastNumberEnd-1;
    this.numbers.remove(lastNumberEnd);
    this.numbers.remove(lastNumberBegginning);
  }

  public void removeNumber(int e){
    int lastNumberEnd = e*2;
    int lastNumberBegginning = lastNumberEnd-1;
    this.numbers.remove(lastNumberEnd);
    this.numbers.remove(lastNumberBegginning);
  }

  public void addParentesisOpen(int p){
    BracketsPairs parentese = new BracketsPairs();
    parentese.setPositionOpen(p);
    this.parentesis.add(parentese);
    if(this.gotPriority4()){
      this.priority4 = true;
      this.firstPriority4 = p;
    }
  }

  public void addParentesisClosed(int p){
    boolean added = false;
    for (int i = this.parentesis.size()-1 ; i > 0 ; i--) {
      if(this.parentesis.get(i).getPositionClosed() != -1){
        this.parentesis.get(i).setPositionClosed(p);
        added = true;
      }
    }
    if(!added){
      //lançar erro
    }
  }

  public void addBracketOpen(int p){
    BracketsPairs bracket = new BracketsPairs();
    bracket.setPositionOpen(p);
    this.parentesis.add(bracket);
    if(this.gotPriority3()){
      this.priority3 = true;
      this.firstPriority3 = p;
    }
  }

  public void addBracketClosed(int p){
    boolean added = false;
    for (int i = this.brackets.size()-1 ; i > 0 ; i--) {
      if(this.brackets.get(i).getPositionClosed() != -1){
        this.brackets.get(i).setPositionClosed(p);
        added = true;
      }
    }
    if(!added){
      //lançar erro
    }
  }
  
}