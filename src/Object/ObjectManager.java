package Object;

import java.awt.Container;
import java.util.ArrayList;
import java.util.List;

import Application.Application;
import Application.Define;
import Application.GSvector2;

public class ObjectManager {

	List<Card> mCardList;

	public ObjectManager( Application app, Container c ){

		// リストを生成
		mCardList = new ArrayList<Card>();

		// プレイヤーと敵のカード生成
		for(int i=0;i<5;i++){

			// 生成
			Card pl = new Card( app, c, new GSvector2( Define.CARD_FIRST_X + i * Define.CARD_SIZE.x, Define.CARD_PLAYER_Y ), i, Define.TYPE_PLAYER );

			// リストに追加
			mCardList.add( pl );
		}
		for(int i=0;i<5;i++){

			// 生成
			Card en = new Card( app, c, new GSvector2( Define.CARD_FIRST_X + i * Define.CARD_SIZE.x, Define.CARD_ENEMY_Y ), i, Define.TYPE_ENEMY );

			// リストに追加
			mCardList.add( en );
		}
	}

	// 更新
	public void update(){

		// 各カードの更新
		for( int i=0; i<mCardList.size(); i++ ){

			mCardList.get(i).update();
		}
	}

	// ゲッター
	public List<Card> getList(){ return mCardList; }
}
