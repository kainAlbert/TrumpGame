package Application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//メッセージ受信のためのスレッド
	public class MesgRecvThread extends Thread {

		private Socket mSocket;
		public static PrintWriter mOut;				//出力用のライター

		// コンストラクタ
		public MesgRecvThread(Socket s){

			mSocket = s;

			try{
				mOut = new PrintWriter(mSocket.getOutputStream(), true);
			}catch( Exception e ){
				e.printStackTrace();
			}
		}

		//通信状況を監視し，受信データによって動作する
		public void run() {

			try{
				InputStreamReader sisr = new InputStreamReader(mSocket.getInputStream());
				BufferedReader br = new BufferedReader(sisr);

				// ループ
				while(true) {

					//データを一行分だけ読み込んでみる
					String inputLine = br.readLine();

					//読み込んだときにデータが読み込まれたかどうかをチェックする
					if (inputLine != null) {

						//デバッグ（動作確認用）にコンソールに出力する
						System.out.println(inputLine);

						//入力データを解析するために、スペースで切り分ける
						String[] inputTokens = inputLine.split(" ");

						//コマンドの取り出し．１つ目の要素を取り出す
						String cmd = inputTokens[0];

						if( Application.getID() == 0 && inputTokens.length == 1 ){

							Application.setID( Integer.parseInt( inputTokens[0] ) );
							System.out.println(Application.getID());
						}

						//MOVEの時の処理(コマの移動の処理)
						if(cmd.equals("MOVE")){

							//ボタンの名前（番号）の取得
							String theBName = inputTokens[1];

							//ボタンの名前を数値に変換する
							int theBnum = Integer.parseInt(theBName);

							int x = Integer.parseInt(inputTokens[2]);
							int y = Integer.parseInt(inputTokens[3]);

							//指定のボタンを位置をx,yに設定する
							//buttonArray[theBnum].setLocation(x,y);
						}
					}else{
						break;
					}

				}
				mSocket.close();
			} catch (IOException e) {
				System.err.println("エラーが発生しました: " + e);
			}
		}

		// サーバーに出力
		public static void outServer( String msg ){

			//送信データをバッファに書き出す
			mOut.println( msg );

			//送信データをフラッシュ（ネットワーク上にはき出す）する
			mOut.flush();
		}
	}
