package javatask190919;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextImportAndSumExport {
	/**
 * コマンドライン引数で渡されたファイル名のテキストファイルを読み込み、<br>
 * その中の総和を算出するプログラムです。
 * @author Shinnosuke Ooe
 * @param args
 *
 */

public static void main(String[] args) {


	try {
		//パラメータ数が2個になっているか確認
		if(args.length != 2) {
			throw new IllegalArgumentException("パラメータ数が過不足しています。パラメータは2個用意してください");
		}
		//ファイルチェック
		File file = new File(args[0]);
		if(!file.exists()) {
			throw new IOException("ファイルが存在しません");
		}
		//読み込みオブジェクトの作成
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		//書き込みファイルの生成

		File result = new File(args[1]);
		result.createNewFile();
		FileWriter fw = new FileWriter(result);
		BufferedWriter bw = new BufferedWriter(fw);

		try {
			String data;

			List<Integer> num = new ArrayList<Integer>();
			int sum = 0, target = 0;
			while((data = br.readLine()) != null) {
				num.add(Integer.parseInt(data));
				sum += num.get(target);
				target += 1;
			}


			bw.write(String.valueOf(sum));
			bw.flush();
			}catch(IOException e) {
				System.out.println("ファイル入出力に関するエラー");
				System.out.println(e);
			}finally {
				bw.close();
				br.close();
			}
		}catch(IOException e) {
			System.out.println("ファイル入出力に関するエラー");
			System.out.println(e);
		}catch(IllegalArgumentException e) {
			System.out.println("パラメータのエラー");
			System.out.println(e);
		}
	}
}
