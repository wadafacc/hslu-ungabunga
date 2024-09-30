#include<stdio.h>


int main(int argc, char *argv[]) {

  double workHours;
  int hourlyRate = 12;

  double tax = 0;
  double pay = 0;
  scanf("%lf", &workHours);

  if (workHours <= 40)
  {
    pay = workHours * hourlyRate;
  }
  else
  {
    pay = 40 * hourlyRate + ((workHours - 40) * hourlyRate * 1.5);
  }
  
  printf("%lf.- ", pay);

  if (pay >= 300) {
    tax = pay * 0.15;
    pay -= 300;
  }
  if (pay >= 150) {
    tax += pay * 0.2;
    pay -= 150;
  }
  if (pay > 0) {
    tax += pay * 0.25;
  }

  printf("%lf Tax", tax);
}