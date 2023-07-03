package com.example.studentcomprehensiveassessmentsystem.controller;

import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import static org.junit.jupiter.api.Assertions.*;

class FileUploadControllerTest {

    @Test
    public void testGetFileExtension_ValidFileName_ReturnsExtension() {
        // 定义一个有效的文件名
        String fileName = "example.txt";

        // 调用 getFileExtension 方法
        String extension = getFileExtension(fileName);

        // 验证返回的扩展名是否为 "txt"
        assertEquals("txt", extension);
    }

    @Test
    public void testGetFileExtension_NoExtension_ReturnsNull() {
        // 定义一个没有扩展名的文件名
        String fileName = "example";

        // 调用 getFileExtension 方法
        String extension = getFileExtension(fileName);

        // 验证返回的扩展名是否为 null
        assertNull(extension);
    }

    @Test
    public void testGetFileExtension_EmptyFileName_ReturnsNull() {
        // 定义一个空的文件名
        String fileName = "";

        // 调用 getFileExtension 方法
        String extension = getFileExtension(fileName);

        // 验证返回的扩展名是否为 null
        assertNull(extension);
    }

    @Test
    public void testGetFileExtension_DotAtEnd_ReturnsNull() {
        // 定义一个文件名以点结尾的情况
        String fileName = "example.";

        // 调用 getFileExtension 方法
        String extension = getFileExtension(fileName);

        // 验证返回的扩展名是否为 null
        assertNull(extension);
    }

    @Test
    public void testGetFileExtension_MultipleDots_ReturnsLastExtension() {
        // 定义一个包含多个点的文件名
        String fileName = "example.test.txt";

        // 调用 getFileExtension 方法
        String extension = getFileExtension(fileName);

        // 验证返回的扩展名是否为 "txt"
        assertEquals("txt", extension);
    }

    private String getFileExtension(String fileName) {
        if (StringUtils.hasText(fileName)) {
            int dotIndex = fileName.lastIndexOf(".");
            if (dotIndex >= 0 && dotIndex < fileName.length() - 1) {
                return fileName.substring(dotIndex + 1);
            }
        }
        return null;
    }

    @Test
    public void testStartsWith_ValidPrefix_ReturnsTrue() {
        // 定义一个有效的字节数组和前缀
        byte[] array = {0x12, 0x34, 0x56, 0x78};
        byte[] prefix = {0x12, 0x34};

        // 调用 startsWith 方法
        boolean result = startsWith(array, prefix);

        // 验证返回值是否为 true
        assertTrue(result);
    }

    @Test
    public void testStartsWith_InvalidPrefix_ReturnsFalse() {
        // 定义一个有效的字节数组和无效的前缀
        byte[] array = {0x12, 0x34, 0x56, 0x78};
        byte[] prefix = {0x45, 0x67};

        // 调用 startsWith 方法
        boolean result = startsWith(array, prefix);

        // 验证返回值是否为 false
        assertFalse(result);
    }

    @Test
    public void testStartsWith_ArrayLengthLessThanPrefix_ReturnsFalse() {
        // 定义一个长度小于前缀的字节数组和前缀
        byte[] array = {0x12, 0x34};
        byte[] prefix = {0x12, 0x34, 0x56};

        // 调用 startsWith 方法
        boolean result = startsWith(array, prefix);

        // 验证返回值是否为 false
        assertFalse(result);
    }

    @Test
    public void testStartsWith_EmptyArrayAndEmptyPrefix_ReturnsTrue() {
        // 定义一个空的字节数组和空的前缀
        byte[] array = {};
        byte[] prefix = {};

        // 调用 startsWith 方法
        boolean result = startsWith(array, prefix);

        // 验证返回值是否为 true
        assertTrue(result);
    }

    private boolean startsWith(byte[] array, byte[] prefix) {
        if (array.length < prefix.length) {
            return false;
        }
        for (int i = 0; i < prefix.length; i++) {
            if (array[i] != prefix[i]) {
                return false;
            }
        }
        return true;
    }
}