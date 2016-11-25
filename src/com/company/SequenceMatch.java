package com.company;

public class SequenceMatch {

    public static void main(String[] args){

        String seq1 = "TACGTCACTGTCGTAAGGGCGGGGGCCTCGTACTACTCTCCTATTGTATGACTTAAACCCTGTATGAAGTATTAGTTCCATATCAGATGGTTACACACCTCCTGCGTATCGTGTAAATGATTGCCGGCTACGTCGGAGAAGAACTCAATT";
        String seq2 = "TACGTCACTGTCGTAAGGGCGGGGGCCTCGTACTACTCTCCTATTGTATGACGGCGCTTAGTTCCATTGACTTAGTTCCATATCAGATGGTTACACACCTCCTGCGTATCGTGTAAATGATTGCCGGCTACGTCGGAGAAGAACTCAATT";

        patternMatch(seq1, seq2);
    }

    public static void patternMatch(String seq1, String seq2){

        for (int i = 0; i < seq1.length(); i++){
            if (!(seq1.charAt(i) == seq2.charAt(i))){
                splice(seq1, seq2, i);
            }
        }
    }

    public static void splice(String seq1, String seq2, int index){
        if ((seq1.charAt(index + 1)) == seq2.charAt(index + 1)){
            seq1 = removeCharAt(seq1, index);
            seq2 = removeCharAt(seq2, index);
        } else {
            permutations(sequenceBuilder(seq1, seq2, index));
        }
    }

    public static String removeCharAt(String seq, int index){
        StringBuffer buffer = new StringBuffer(seq.length() - 1);
        buffer.append(seq.substring(0, index)).append(seq.substring(index + 1));
        return buffer.toString();
    }

    public static String sequenceBuilder(String seq1, String seq2, int index){
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(seq1.substring(index, index + 2));
        stringBuilder.append(seq2.substring(index, index + 2));

        return stringBuilder.toString();
    }

    public static void permutations(String seq){
        int size = seq.length();
        char[] characters = new char[size];
        for (int i = 0; i < size; i++){
            characters[i] = seq.charAt(i);
        }
        permutations2(characters, size);
    }

    public static void permutations2(char[] characters, int size){
        if (size == 1){
            System.out.println(characters);
        } else {
            for (int i = 0; i < size; i++){
                swap(characters, i, size - 1);
                permutations2(characters, size - 1);
                swap(characters, i, size - 1);
            }
        }
    }

    public static void swap(char[] x, int i, int j){
        char c = x[i];
        x[i] = x[j];
        x[j] = c;
    }

}
