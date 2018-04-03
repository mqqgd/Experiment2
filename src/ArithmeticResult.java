import java.util.HashMap;  
import java.util.Stack;    
public class ArithmeticResult {  
    public Double Result(String formula) {  
        Stack<Double> s1 = new Stack<Double>();
        Stack<String> s2 = new Stack<String>();
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();  
        hashMap.put("(", 0);  
        hashMap.put("+", 1);  
        hashMap.put("-", 1);  
        hashMap.put("¡Á", 2);  
        hashMap.put("¡Â", 2);  
        for (int i = 0; i < formula.length();) {  
            StringBuffer digit = new StringBuffer();  
            char c = formula.charAt(i);  
            while (Character.isDigit(c) || c == '.') {  
                digit.append(c);  
                i++;  
                c = formula.charAt(i);  
            }  
            if (digit.length() == 0) {  
                switch (c) {  
                case '(': {  
                    s2.push(String.valueOf(c));  
                    break;  
                }  
                case ')': {  
                    String stmp = s2.pop();  
                    while (!s2.isEmpty() && !stmp.equals("(")) {  
                        double a = s1.pop();  
                        double b = s1.pop();  
                        double sresulat = calcDouble(b, a, stmp);  
                        s1.push(sresulat);  
                        stmp = s2.pop();  
                    }  
                    break;  
                }  
                case '=': {  
                    String stmp;  
                    while (!s2.isEmpty()) {  
                        stmp = s2.pop();  
                        double a = s1.pop();  
                        double b = s1.pop();  
                        double sresulat = calcDouble(b, a, stmp);  
                        s1.push(sresulat);  
                    }  
                    break;  
                }  
                default: {  
                    String stmp;  
                    while (!s2.isEmpty()) {  
                        stmp = s2.pop();  
                        if (hashMap.get(stmp) >= hashMap.get(String.valueOf(c))) {  
                            double a = s1.pop();  
                            double b = s1.pop();  
                            double sresulat = calcDouble(b, a, stmp);  
                            s1.push(sresulat);  
  
                        } else {  
                            s2.push(stmp);  
                            break;  
                        }  
  
                    }  
                    s2.push(String.valueOf(c));  
                    break;  
                }  
                }  
            } else {  
                s1.push(Double.valueOf(digit.toString()));  
                continue;  
            }  
            i++;  
        }  
        return s1.peek();  
    }  
  
    public double calcDouble(double a, double b, String stmp) {  
        double res = 0f;  
        char s = stmp.charAt(0);  
        switch (s) {  
          case '+':
            res = a + b;  
            break;  
          case '-':  
            res = a - b;  
            break;  
          case '¡Á':
            res = a * b;  
            break;  
          case '¡Â':
            res = a / b;  
            break;  
        }  
        return res;
    }    
}  