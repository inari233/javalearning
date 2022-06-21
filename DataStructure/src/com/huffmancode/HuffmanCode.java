package com.huffmancode;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class HuffmanCode {
    public static void main(String[] args) {
//        String str = "i like like like java do you like a java";
//        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
//        byte[] zip = huffman.zip(bytes);
//        HashMap<Byte, String> map = huffman.map;
//        byte[] decode = huffman.decode(map, zip);
//        System.out.println(new String(decode));
        String src = "f:\\a2.zip";
        String des = "f:\\a3.txt";
        huffman.unzip(src, des);

    }
}

class toList {
    public static List<node> getNodes(byte[] bytes) {
        ArrayList<node> nodes = new ArrayList<>();
        HashMap<Byte, Integer> map = new HashMap<>();
        for (byte aByte : bytes) {
            Integer count = map.get(aByte);
            if (count == null) {
                map.put(aByte, 1);
            } else {
                map.put(aByte, count + 1);
            }
        }

        //遍历map，创建list
        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            nodes.add(new node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }
}

class node {
    node left;
    node right;
    Byte data;
    int value;


    public node(Byte data, int value) {
        this.value = value;
        this.data = data;
    }

    @Override
    public String toString() {
        return "node{" +
                "data=" + data +
                ", value=" + value +
                '}';
    }

    public static void preOrder(node node) {
        if (node == null) {
            return;
        }
        System.out.println(node);
        preOrder(node.left);
        preOrder(node.right);
    }
}

class huffman {
    public static HashMap<Byte, String> map = new HashMap<>();
    public static StringBuilder stringBuilder = new StringBuilder();


    public static void unzip(String src, String des){
        ObjectInputStream ois = null;
        FileOutputStream os = null;

        try {
            os = new FileOutputStream(des);
            ois = new ObjectInputStream(new FileInputStream(src));
            byte[] huffmanCode = (byte[]) ois.readObject();
            HashMap<Byte, String> map = (HashMap<Byte, String>) ois.readObject();
            byte[] decode = huffman.decode(map, huffmanCode);
            os.write(decode);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                ois.close();
                os.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public static void zipFile(String src, String des){
        FileInputStream is = null;
        ObjectOutputStream oos = null;

        try {
            is = new FileInputStream(src);
            byte[] bytes = new byte[is.available()];
            is.read(bytes);
            byte[] zip = huffman.zip(bytes);
            oos = new ObjectOutputStream(new FileOutputStream(des));
            oos.writeObject(zip);
            oos.writeObject(huffman.map);

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                oos.close();
                is.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }


    /**
     * 
     * @param huffmanCodes huffman编码表
     * @param huffmanBytes huffman的字节数组
     * @return 解读完的二进制字节数组
     */
    public static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes){
        //先将bytes数组转换成对应的字符串
        StringBuilder stringBuilder1 = new StringBuilder();
        for (int i  = 0; i  < huffmanBytes.length; i ++) {
            boolean flag = (i == huffmanBytes.length - 1);
            stringBuilder1.append(byteToString(!flag, huffmanBytes[i]));
        }

        //拿到字符串后，将指定的字符串按照编码表进行解码
        //可以将对应的编码便反向编码
        HashMap<String, Byte> reverse_Map = new HashMap<>();
        for (Map.Entry<Byte, String> byteStringEntry : huffmanCodes.entrySet()) {
            reverse_Map.put(byteStringEntry.getValue(), byteStringEntry.getKey());
        }

        List<Byte> list = new ArrayList<>();

        for (int i = 0; i < stringBuilder1.length();) {
            int count = 1;
            boolean flag = true;
            Byte b = null;

            while (flag){
                String key;
                key = stringBuilder1.substring(i, i + count);
                b = reverse_Map.get(key);
                if(b == null){
                    count++;
                } else {
                    flag = false;
                }
            }
            list.add(b);
            i += count;
        }
        byte[] b = new byte[list.size()];
        for (int i = 0; i < b.length; i++) {
            b[i] = list.get(i);
        }
        return b;
    }


    /**
     * 将二进制数组装换成字符串
     * @param flag 判断是否要补高位
     * @param b 需要处理的字节数组
     * @return 返回的字符串
     */
    public static String byteToString(boolean flag, byte b){
        int temp = b;
        //根据flag判断是否需要补高位
        if(flag){
            temp |= 256;//按位与，操作完后就可以把对应的8位二进制补完
        }
        String str = Integer.toBinaryString(temp);//返回的是temp对应的二进制补码

        if(flag && temp < 0){
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }



    public static byte[] zip(byte[] bytes){
        List<node> nodes = toList.getNodes(bytes);
        huffman.createHuffman(nodes);
        node head = nodes.get(0);
        huffman.getCodes(head, "", new StringBuilder());
        HashMap<Byte, String> map = huffman.map;
        StringBuilder stringBuilder = new StringBuilder();
        for (byte aByte : bytes) {
            stringBuilder.append(map.get(aByte));
        }
        byte[] huffmanCode = new byte[(stringBuilder.length() + 7) / 8];
        int index = 0;
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            if(i + 8 > stringBuilder.length()){
                huffmanCode[index++] = (byte) Integer.parseInt(stringBuilder.substring(i), 2);
            } else {
                huffmanCode[index++] = (byte) Integer.parseInt(stringBuilder.substring(i,i + 8), 2);
            }
        }
        return huffmanCode;
    }

    /**
     * 传入的结点的所有叶子结点得到，并且存入到map中
     *
     * @param node 传入的机电
     * @param code 需要拼接的编码，规定向左为0，向右为1
     */
    public static void getCodes(node node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        stringBuilder1.append(code);
        if (node != null) {
            if (node.data == null) {
                getCodes(node.left, "0", stringBuilder1);
                getCodes(node.right, "1", stringBuilder1);
            } else {
                map.put(node.data, stringBuilder1.toString());
            }
        }


    }

    public static void createHuffman(List<node> nodes) {
        while (nodes.size() > 1) {
            nodes.sort(new Comparator<node>() {
                @Override
                public int compare(node o1, node o2) {
                    return o1.value - o2.value;
                }
            });
            node node1 = nodes.get(0);
            node node2 = nodes.get(1);
            node node3 = new node(null, node1.value + node2.value);
            nodes.remove(node1);
            nodes.remove(node2);
            node3.left = node1;
            node3.right = node2;
            nodes.add(node3);
        }
    }
}