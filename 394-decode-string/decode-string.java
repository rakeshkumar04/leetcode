class Solution {
    public String decodeString(String s) {
       Stack<Character> st = new Stack<>();

       for(char c: s.toCharArray()){
            if(c!=']') st.push(c);

            else{
                StringBuilder temp = new StringBuilder();
                while(!st.isEmpty() && st.peek()!='['){
                    temp.append(st.pop());
                }
                temp.reverse();
                st.pop();

                StringBuilder num = new StringBuilder();
                while(!st.isEmpty() && Character.isDigit(st.peek())){
                    num.insert(0, st.pop());
                }

                int number = Integer.parseInt(num.toString());
                StringBuilder repeat = new StringBuilder();

                for(int i=0; i<number; i++){
                    repeat.append(temp);
                }

                for(char ch: repeat.toString().toCharArray()){
                    st.push(ch);
                }
            }

            
       }

        StringBuilder res = new StringBuilder();
            
        while(!st.isEmpty()){
        res.append(st.pop());
        }

        res.reverse();

        return res.toString();
    }
}