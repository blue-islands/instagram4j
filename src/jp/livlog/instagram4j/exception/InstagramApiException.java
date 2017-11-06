package jp.livlog.instagram4j.exception;

public class InstagramApiException extends Exception {

    /**
     * シリアルバージョンUID
     */
    private static final long serialVersionUID = 1L;


    /**
     * デフォルト・コンストラクタ
     */
    public InstagramApiException() {

        super();
    }


    /**
     * メッセージ付け異常を構築する
     * @param message エラーメッセージ
     */
    public InstagramApiException(final String message) {

        super(message);
    }


    /**
     * メッセージ付け、異常の発生元（throwable）情報を持つ異常を構築する
     * @param message
     * @param throwable
     */
    public InstagramApiException(final String message, final Throwable throwable) {

        super(message, throwable);
    }


    /**
     * 異常を発生する元（throwable）情報を持つ異常を構築する
     * @param throwable
     *            Throwable
     */
    public InstagramApiException(final Throwable throwable) {

        super(throwable);
    }
}
