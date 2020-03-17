package com.example.practicechattingapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;

import java.io.ByteArrayOutputStream;

public class HBitmapTool {
    //비트맵을 문자열로 변환해주는 함수
    public static String hBitmapToString(Bitmap hbitmap){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();//BAOS 참조변수 형성
        hbitmap.compress(Bitmap.CompressFormat.JPEG, 70, baos);//받은 비트맵을 압축(decoding), quality는 압축률
        byte[] imagebytes = baos.toByteArray();//읽어들인 배열을 byte 배열로 저장
        return Base64.encodeToString(imagebytes, Base64.NO_WRAP);//byte 배열을 Base64로 encoding, NO_WRAP은 아무런 가공도 하지 않음을 의미
        //*Base64는 byte를 아스키코드를 이용해서 문자로 인코딩, 디코딩 해주는 class
        //*ByteArrayOutPutStream은 byte 배열을 순차적으로 읽기 위한 class, 내부 저장소 이용
    }

    //문자열(비트맵이었던)을 비트맵으로 변환해주는 함수
    public static Bitmap hStringToBitmap(String hstring) {
        try {//잘못된 문자열(bitmap이 변환된 것이 아닌 문자열 등) 입력을 감지하기 위한 예외처리
            byte[] decodebytearray = Base64.decode(hstring, Base64.NO_WRAP);//문자열을 base64로 decoding해서 bytearray에 저장
            Bitmap decodedBitmap = BitmapFactory.decodeByteArray(decodebytearray, 0, decodebytearray.length);
            return decodedBitmap;
        } catch(Exception e){
            e.getMessage();
            Log.d("hStringToBitmap", "문자열 비트맵 변환 오류 ");
            return null;
        }
    }
}
