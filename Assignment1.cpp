#include <iostream>
using namespace std;

// Complexity: ??
int min(int index, int n) {
  int num;
  cin >> num;
  if (index == n - 1) {
    return num;
  }
  int minimum = min(index + 1, n);
  return num < minimum ? num : minimum;
}

void task1() {
  int n;
  cin >> n;
  int minimum = min(0, n);
  cout << minimum;
}

double average(int n) {
  int num;
  cin >> num;
  if (n == 1) {
    return num;
  }
  return (num + average(n - 1)) / n;
}

void task2() {
  int n;
  cin >> n;
  cout << average(n);
}

bool prime(int n, int div = 2) {
  if (n <= 2) {
    return (n == 2);
  }
  if (n % div == 0) {
    return false;
  }
  if (div * div > n) {
    return true;
  }
  return prime(n, div + 1);
}

void task3() {
  int n;
  cin >> n;
  if (prime(n)) {
    cout << "YES";
  } else {
    cout << "NO";
  }
}

int factorial(int n){
  if(n == 1){
    return 1;
  }
  return n * factorial(n - 1);
}

void task4(){
  int n;
  cin >> n;
  cout << factorial(n);
}

int fibonachi(int n){
  if(n == 1 || n == 2){
    return 1;
  }
  return fibonachi(n - 1) + fibonachi(n - 2);
}

void task5(){
  int n;
  cin >> n;
  cout << fibonachi(n);
}

int power(int n, int p){
  if(p == 0){
    return 1;
  }
  return n * power(n, p - 1);
}

void task6(){
  int n, p;
  cin >> n >> p;
  cout << power(n, p);
}

bool stringDigitCheck(string str, int index = 0){
  if(index == str.length()){
    return true;
  }
  if(!isdigit(str[index])){
    return false;
  }
  return stringDigitCheck(str, index + 1);
}

void task8(){
  string str;
  cin >> str;
  if(stringDigitCheck(str)){
    cout << "YES";
  }
  else{
    cout << "NO";
  }
}

int GCD(int a, int b){
  if(a == b){
    return a;
  }
  if(a > b){
    return GCD(a - b, b);
  }
  return GCD(a, b - a);
}

int binomialCoefficent(int n, int k){
  if(k == 0 || k == n){
    return 1;
  }
  return binomialCoefficent(n - 1, k - 1) + binomialCoefficent(n - 1, k);
}

void task9(){
  int n, k;
  cin >> n >> k;
  cout << binomialCoefficent(n, k);
}

void task10(){
  int a, b;
  cin >> a >> b;
  cout << GCD(a, b);
}

int main() {
  task1();
  task2();
  task3();
  task4();
  task5();
  task6();
  task8();
  task9();
  task10();
}