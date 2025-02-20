＜実行手順＞
1.ソースをダウンロード
2.コンテナを起動
　docker-compose up
3.コンテナが起動していることを確認
　docker ps
4.Flywayマイグレーション実行
　./gradlew flywayMigrate
5.プロジェクト開始（DBの実装が上手く出来ていないので、途中でエラーが出力されてます。）
　./gradlew bootRun

　（テスト実行）
　./gradlew test
