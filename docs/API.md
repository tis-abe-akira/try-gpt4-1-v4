# API一覧

## 顧客API（/api/customers）

### 顧客一覧取得（ページング対応）
- GET /api/customers?page=0&size=10
- レスポンス: CustomerResponseDto[]

### 顧客詳細取得
- GET /api/customers/{id}
- レスポンス: CustomerResponseDto
- 404: 存在しない場合

### 顧客新規作成
- POST /api/customers
- リクエスト: CustomerRequestDto
- レスポンス: CustomerResponseDto
- 201: 作成成功
- 400: バリデーションエラー

### 顧客更新
- PUT /api/customers/{id}
- リクエスト: CustomerRequestDto
- レスポンス: CustomerResponseDto
- 404: 存在しない場合
- 400: バリデーションエラー

### 顧客削除
- DELETE /api/customers/{id}
- レスポンス: なし
- 204: 削除成功
- 404: 存在しない場合

---

## プロジェクトAPI（/api/projects）

### プロジェクト一覧取得（ページング対応）
- GET /api/projects?page=0&size=10
- レスポンス: ProjectResponseDto[]

### プロジェクト詳細取得
- GET /api/projects/{id}
- レスポンス: ProjectResponseDto
- 404: 存在しない場合

### プロジェクト新規作成
- POST /api/projects
- リクエスト: ProjectRequestDto
- レスポンス: ProjectResponseDto
- 201: 作成成功
- 400: バリデーションエラー or customerId不正

### プロジェクト更新
- PUT /api/projects/{id}
- リクエスト: ProjectRequestDto
- レスポンス: ProjectResponseDto
- 404: 存在しない場合
- 400: バリデーションエラー or customerId不正

### プロジェクト削除
- DELETE /api/projects/{id}
- レスポンス: なし
- 204: 削除成功
- 404: 存在しない場合

---

## APIとテーブルCRUD対応表

| APIエンドポイント                | 操作   | 対象テーブル  |
|----------------------------------|--------|--------------|
| GET    /api/customers            | R(一覧) | customer     |
| GET    /api/customers/{id}       | R(単体) | customer     |
| POST   /api/customers            | C      | customer     |
| PUT    /api/customers/{id}       | U      | customer     |
| DELETE /api/customers/{id}       | D      | customer     |
| GET    /api/projects             | R(一覧) | project      |
| GET    /api/projects/{id}        | R(単体) | project      |
| POST   /api/projects             | C      | project      |
| PUT    /api/projects/{id}        | U      | project      |
| DELETE /api/projects/{id}        | D      | project      |

---

## エラー例
- 400: バリデーションエラー時は { "message": "Validation failed", "status": 400, "details": [ { "field": "name", "message": "nameは5文字以内で入力してね" } ] }
- 404: { "message": "Customer not found", "status": 404 }
- 400: 参照整合性違反時は { "message": "データ整合性エラー: 関連する顧客が存在しません、またはDB制約違反です。", "status": 400 }

---

何か追加で知りたいAPI仕様があれば教えて！
