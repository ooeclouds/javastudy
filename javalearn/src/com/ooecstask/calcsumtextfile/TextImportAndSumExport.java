package com.ooecstask.calcsumtextfile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * パラメータをファイル名として受け取り,<br>
 * 入力用テキストファイル内の各行の数値を読み取り,<br>
 * その総和を出力用テキストファイルに出力するプログラム.
 *
 * @author Shinnosuke Ooe
 * @version 1.0
 *
 **/

public class TextImportAndSumExport {

  /**
  * 処理を全て行なっているメソッド.<br>
  * パラメータのファイル名を持つ入力用ファイル名を用意する.<br>
  * 入力用ファイル名の内容は総和を求めたい数値を改行で分け,<br>
  * -214783648〜214783647の半角数字で入力したもののみ受け付ける.<br>
  * 出力ファイルは用意する必要は無いが,既に存在していた場合,<br>
  * 中身は全て消去され入力ファイルの総和のみが入ったものに更新される.
  *
  * @param args 入力ファイル名 出力ファイル名
  **/
  public static void main(String[] args) {

    try {
      //出力用テキスト名と入力用テキスト名に使うパラメータが合計2個あるか確認
      if (args.length != 2) {
        throw new IllegalArgumentException("パラメータ数が過不足しています。パラメータは2個用意してください");
      }

      //入力用テキストが存在する事を確認
      File file = new File(args[0]);

      if (!file.exists()) {
        throw new IOException("ファイルが存在しません");
      }

      FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr);

      File result = new File(args[1]);
      //出力用テキストファイルが存在しない場合新規作成する.
      //存在し既存の出力用テキストファイルが書き込み可能なら内容を初期化
      result.createNewFile();
      FileWriter fw = new FileWriter(result);
      BufferedWriter bw = new BufferedWriter(fw);
      String data;
      List<String> num = new ArrayList<String>();
      int sum = 0;
      int target = 0;
      //入力用テキストの次に読み込む行が数値に変換可能な値である
      try {
        //入力用テキストファイルの末尾を読み込んだ場合ループ終了
        while ((data = br.readLine()) != null) {
          //入力用テキストファイルを1行読み込む
          num.add(data);

          //読み込んだ値を数値に変換し、
          //合計値に数値を足した時扱える最大値を超えない事を確認、
          //数値を合計値に足す
          sum = Math.addExact(sum,Integer.parseInt(num.get(target)));
          target += 1;
        }

        //出力用テキストファイルに合計値を書き込む
        bw.write(String.valueOf(sum));
        bw.flush();

        System.out.println("出力が正常に終了しました");

      } catch (IOException e) {
        System.out.println("ファイル入出力に関するエラー");
        System.out.println("エラーメッセージ　：" + e);
      } catch (IllegalArgumentException e) {
        System.out.println("数値以外または許可されない数値がテキストに含まれています。\n"
            + "数値は" + Integer.MIN_VALUE + "〜" + Integer.MAX_VALUE + "の間の半角数字で入力してください");
        System.out.println("エラーメッセージ：" + e);
      } finally {
        //読み込みと書き込みファイルを閉じる
        bw.close();
        br.close();
      }
    } catch (IOException e) {
      System.out.println("ファイル入出力に関するエラー");
      System.out.println("エラーメッセージ：" + e);
    } catch (IllegalArgumentException e) {
      System.out.println("パラメータのエラー");
      System.out.println("エラーメッセージ：" + e);
    } catch (ArithmeticException e) {
      System.out.println("エラーメッセージ：" + e);
    }
  }
}
