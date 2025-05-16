# try-gpt4-1 プロジェクト概要

## ✨ プロジェクト概要

このプロジェクトは、Spring Boot 3.4.5・Java 17・MyBatis・H2 Databaseを使ったサンプルWebアプリ。
顧客（Customer）とプロジェクト（Project）のマスタ管理をREST APIでCRUDできる設計になってる。

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
- **Customer**: 名前（5文字以内）・連絡先・業種
- **Project**: Customer参照、担当部署・PM・PL・売上・開始日・終了日・区分（新規/保守/パッケージ）
  - ランク（S/A/B/C/D）はsalesAmount（金額）から自動決定

## 🚀 REST API
- `/api/customers` ... 顧客CRUD
- `/api/projects` ... プロジェクトCRUD
- ページング: `GET /api/customers?page=0&size=10` など
- 詳細は [docs/API.md](docs/API.md)・[docs/openapi.yaml](docs/openapi.yaml) を参照（ProjectのランクはsalesAmountで自動決定）

## 💡 開発Tips
- DBスキーマは `src/main/resources/schema.sql` で自動生成
- サンプルデータは `src/main/resources/data.sql` で自動投入
- MyBatisマッパーは `src/main/resources/mapper/` 配下
- バリデーションは `jakarta.validation.constraints` を利用
- Swagger UIは `/swagger-ui.html` でアクセス可能（springdoc-openapi）
- 例外・バリデーションエラーは詳細なJSONで返却

## 📄 ドキュメント
- [設計書](docs/設計書.md)
- [API仕様](docs/API.md)
- [クラス図（PlantUML）](docs/class-diagram.puml)
- [OpenAPI定義](docs/openapi.yaml)
- [Service層テスト観点](docs/test-case.md)

## 🏃‍♀️ 起動方法
```bash
./mvnw clean spring-boot:run
```

## 注意点
- 顧客名は5文字以内、バリデーションエラー時は詳細なエラー内容が返る
- プロジェクト登録時、customerIdが存在しない場合は400エラー
- プロジェクト登録・更新時、projectRankはリクエスト不要。salesAmountで自動決定される
- サンプルデータは英字のみ（文字化け防止）
- ページングはJava側で実装（大量データ時はSQL側での対応推奨）
- 詳細なAPI仕様・エラー例はAPI.md/openapi.yaml参照

---
質問・要望があれば気軽にどうぞ！
