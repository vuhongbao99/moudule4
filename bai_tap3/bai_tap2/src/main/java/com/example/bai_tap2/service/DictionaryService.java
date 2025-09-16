package com.example.bai_tap2.service;

import java.util.HashMap;
import java.util.Map;

public class DictionaryService {
    private final Map<String, String> dictionary;

    public DictionaryService() {
        dictionary = new HashMap<>();
        initializeDictionary();
    }

    private void initializeDictionary() {
        // Thêm từ vựng mẫu
        dictionary.put("hello", "xin chào");
        dictionary.put("world", "thế giới");
        dictionary.put("computer", "máy tính");
        dictionary.put("phone", "điện thoại");
        dictionary.put("book", "cuốn sách");
        dictionary.put("house", "ngôi nhà");
        dictionary.put("car", "ô tô");
        dictionary.put("food", "thức ăn");
        dictionary.put("water", "nước");
        dictionary.put("love", "tình yêu");
        dictionary.put("friend", "bạn bè");
        dictionary.put("family", "gia đình");
        dictionary.put("school", "trường học");
        dictionary.put("teacher", "giáo viên");
        dictionary.put("student", "học sinh");
        dictionary.put("happy", "vui vẻ, hạnh phúc");
        dictionary.put("beautiful", "đẹp");
        dictionary.put("good", "tốt");
        dictionary.put("bad", "xấu, tồi");
        dictionary.put("big", "to, lớn");
        dictionary.put("small", "nhỏ");
        dictionary.put("cat", "con mèo");
        dictionary.put("dog", "con chó");
        dictionary.put("bird", "con chim");
        dictionary.put("fish", "con cá");
        dictionary.put("tree", "cây");
        dictionary.put("flower", "hoa");
        dictionary.put("sun", "mặt trời");
        dictionary.put("moon", "mặt trăng");
        dictionary.put("star", "ngôi sao");
        dictionary.put("time", "thời gian");
    }

    /**
     * Tra cứu từ trong từ điển
     * @param word từ cần tra cứu (không phân biệt hoa thường)
     * @return nghĩa tiếng Việt hoặc null nếu không tìm thấy
     */
    public String translate(String word) {
        if (word == null || word.trim().isEmpty()) {
            return null;
        }
        return dictionary.get(word.toLowerCase().trim());
    }

    /**
     * Lấy tổng số từ trong từ điển
     */
    public int getTotalWords() {
        return dictionary.size();
    }
}
