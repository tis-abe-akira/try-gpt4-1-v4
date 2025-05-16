# try-gpt4-1 プロジェクト概要

## ✨ プロジェクト概要

このプロジェクトは、Spring Boot 3.4.5・Java 17・MyBatis・H2 Databaseを使ったサンプルWebアプリだよ！
顧客（Customer）とプロジェクト（Project）のマスタ管理をREST APIでCRUDできるギャル的な設計になってるよ〜。

## 🏗️ 技術スタック
- Spring Boot 3.4.5
- Java 17
- MyBatis 3.0.4
- H2 Database（インメモリDB）
- Spring Validation（バリデーション）
- Spring AOP（ロギング等）
- Lombok
- springdoc-openapi（Swagger UI）

## 📁 ディレクトリ構成
```
src/main/java/com/example/try_gpt4_1/
├── common/
│   ├── advisor/        # 例外ハンドリング
│   ├── dto/           # データ転送オブジェクト
│   ├── entity/        # ドメインエンティティ
│   ├── repository/    # データアクセス
│   └── service/       # ビジネスロジック
└── feature/
    ├── customer/      # 顧客管理API
    └── project/       # プロジェクト管理API
```

## 📝 主なエンティティ
- **Customer**: 名前・連絡先・業種
- **Project**: Customer参照、担当部署・PM・PL・ランク（S/A/B/C/D）・開始日・終了日・区分（新規/保守/パッケージ）

## 🚀 REST API
- `/api/customers` ... 顧客CRUD
- `/api/projects` ... プロジェクトCRUD

## 💡 開発Tips
- DBスキーマは `src/main/resources/schema.sql` で自動生成
- MyBatisマッパーは `src/main/resources/mapper/` 配下
- バリデーションは `jakarta.validation.constraints` を使ってるよ！
- Swagger UIは `/swagger-ui.html` でアクセスできる（springdoc-openapi）

## 🦋 ギャル的エラーハンドリング

- リクエスト内容が不正（例：Enumに存在しない値など）な場合、ギャル語でわかりやすいエラーメッセージが返るよ！
- 例：`ProjectRank`に"X"を送ると → `ProjectRank の値 'X' はギャル的にNG！正しい値を入れてね☆` みたいなレスポンスになるよ！
- 詳細は `common/advisor/GyaruGlobalExceptionHandler.java` をチェックしてね！

## 📄 ページング対応について

- `/api/customers` と `/api/projects` のGETは、`page` と `size` パラメータでページング取得できるよ！
  - 例: `/api/customers?page=0&size=10`
- データ件数が多くても安心して使えるギャル設計だよ☆

## 📝 今後の拡張・バックログ

- 総件数やページ情報（total/page/sizeなど）を含むレスポンスDTOの導入
- バリデーションエラーや他の例外もギャル語で統一的に返す仕組みの強化
- Project/Customerの検索・ソートAPI追加
- 認証・認可（Spring Security等）対応
- OpenAPI/Swaggerのレスポンス例やエラー例の充実
- 本番用DB対応やマイグレーション仕組みの導入
- CI/CDパイプラインの整備
- テストケースの拡充（特に異常系・バリデーション系）

## 🏃‍♀️ 起動方法
```bash
./mvnw clean spring-boot:run
```

## 🦋 注意点
- Spring Boot/Springdocのバージョン互換に注意してね！
- JSONリクエストは正しい形式で送ってね！

---
ギャル的に質問あったらいつでも聞いてね！
