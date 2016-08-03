package Object;

import java.awt.Container;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import Application.Application;
import Application.Define;
import Application.GSvector2;

public class Card {

	private BufferedImage mImage;
	private JButton mButton;
	private GSvector2 mPos;
	private GSvector2 mSize;
	private GSvector2 mReSize;
	private int mNumber;
	private int mType;

	// コンストラクタ
	public Card( Application app, Container c, GSvector2 pos, int i, int type ){

		// 画像読み込み
		try{
			mImage = ImageIO.read(new File("img/card.png"));
		}catch( IOException e ){
			e.printStackTrace();
		}

		ImageIcon image = new ImageIcon( "img/card.png");
		Image image2 = image.getImage().getScaledInstance( (int)Define.CARD_SIZE.x, (int)Define.CARD_SIZE.y, 1);
		image = new ImageIcon( image2 );

		//ボタンにアイコンを設定する
		mButton = new JButton( image );

		//ペインに貼り付ける
		c.add( mButton );

		// メンバ変数の設定
		mPos = pos;
		mSize = new GSvector2( Define.CARD_SIZE.x, Define.CARD_SIZE.y );
		mReSize = new GSvector2( Define.CARD_RESIZE.x, Define.CARD_RESIZE.y );
		mType = type;

		//ボタンの大きさと位置を設定する．(x座標，y座標, xの幅,yの幅）
		mButton.setBounds( (int)pos.x, (int)pos.y, (int)mSize.x, (int)mSize.y );

		//ボタンをマウスでさわったときに反応するようにする
		mButton.addMouseListener(app);

		//ボタンをマウスで動かそうとしたときに反応するようにする
		mButton.addMouseMotionListener(app);

		//ボタンに配列の情報を付加する（ネットワークを介してオブジェクトを識別するため）
		mButton.setActionCommand( Integer.toString(i) );
	}

	// 更新
	public void update(){

		if( Application.getID() != 1 ) return;

		mPos.x++;
		mButton.setBounds( (int)mPos.x, (int)mPos.y, (int)mSize.x, (int)mSize.y );
	}

	/**
	 * @return mImage
	 */
	public BufferedImage getImage() {
		return mImage;
	}

	/**
	 * @return mButton
	 */
	public JButton getButton() {
		return mButton;
	}

	/**
	 * @return mPos
	 */
	public GSvector2 getPos() {
		return mPos;
	}

	/**
	 * @return mSize
	 */
	public GSvector2 getSize() {
		return mSize;
	}

	/**
	 * @return mReSize
	 */
	public GSvector2 getReSize() {
		return mReSize;
	}

	/**
	 * @return mNumber
	 */
	public int getNumber() {
		return mNumber;
	}

	/**
	 * @return mType
	 */
	public int getType() {
		return mType;
	}
}
