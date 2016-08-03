package Application;

public interface Define {

	// ウィンドウ関連
	GSvector2 WINDOW_SIZE = new GSvector2( 800, 600 );

	// プレイヤー属性
	int TYPE_PLAYER = 1;
	int TYPE_ENEMY = 2;

	// カード関連
	int CARD_FIRST_X = 100;
	int CARD_PLAYER_Y = 400;
	int CARD_ENEMY_Y = 50;
	GSvector2 CARD_SIZE = new GSvector2( 80, 150 );
	GSvector2 CARD_RESIZE = new GSvector2( 256, 256 );
}
