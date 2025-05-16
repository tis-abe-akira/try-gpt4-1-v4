# Optional Requests

- Service層でソート用カラム名・順序（sortColumn/sortOrder）のバリデーションを追加し、不正な値はIllegalArgumentExceptionで弾くようにしたこと
- 許可カラムリスト（ALLOWED_COLUMNS）をstatic finalで定義し、SQLインジェクション対策を強化したこと
- 複数カラムソートに対応し、Listで受けたカラム・順序を組み合わせてORDER BY句を組み立てるようにしたこと
- バリデーションエラー時はAdvisorでキャッチし、400 Bad Requestとして分かりやすいメッセージで返すようにしたこと
- Projectの検索APIでページング・複数条件・複数ソートに対応したこと
- 例外処理・バリデーションの責務をControllerではなくService層に集約したこと
