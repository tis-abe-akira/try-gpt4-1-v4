# クラス図（Mermaid形式）

このシステムの主要なドメインモデル（顧客・プロジェクト・ランク・種別）の関係をMermaid記法で図示。

- Customer（顧客）: 顧客マスタ情報
- Project（プロジェクト）: 顧客に紐づくプロジェクト情報
- ProjectRank: プロジェクトの売上金額に応じたランク（S/A/B/C/D）
- ProjectType: プロジェクト種別（新規開発・保守・パッケージ導入）

```mermaid
classDiagram
    class Customer {
        Long id
        String name
        String contact
        String industry
    }
    class Project {
        Long id
        Long customerId
        String departmentName
        String projectManager
        String projectLeader
        ProjectRank projectRank
        Integer salesAmount
        LocalDate startDate
        LocalDate endDate
        ProjectType projectType
    }
    class ProjectRank {
        S
        A
        B
        C
        D
    }
    class ProjectType {
        NEW_DEVELOPMENT
        MAINTENANCE
        PACKAGE_INTRODUCTION
    }
    Customer "1" --> "*" Project : customerId
```
