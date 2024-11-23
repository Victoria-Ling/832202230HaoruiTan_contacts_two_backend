
Source: (https://blog.csdn.net/qq\_34869143/article/details/94554253)

Certainly! Here’s a revised version of the Java code style guide:

\---

\## Java Code Style Guidelines

\### 1. Naming Conventions

\#### 1.1 General Principles

Names should be consistent, meaningful, and concise.

\##### Consistency

Use the same term for the same concept throughout your project. For instance, choose either "supplier" or "provider" and stick with it. Consistency prevents confusion and aids comprehensibility.

\##### Meaningfulness

Identifiers should clearly represent their purpose. For example, `newSupplier` and `OrderPaymentGatewayService` are clear, while `supplier1` and `service2` are not. Ensure names are accurate and descriptive.

\##### Conciseness

Names should be as brief as possible without losing clarity. Avoid overly long identifiers, and refrain from using obscure abbreviations.

\##### CamelCase

In Java, use CamelCase for most identifiers except package names and constants. This involves capitalizing the first letter of each word, like `supplierName` and `addNewContract`.

\##### English vs. Pinyin

Use common English words; if unsure, consult your team. If necessary, use Pinyin, but avoid mixing with English.

\#### 1.2 Package Names

Use lowercase letters for package names, such as `com.example.project`. Avoid separators like underscores.

\#### 1.3 Class Names

\##### Capitalization

Start class names with an uppercase letter, such as `SupplierService`.

\##### Suffixes

Use suffixes to convey additional meanings:

\- `Service`: Business logic class, e.g., `PaymentOrderService`.

\- `Impl`: Implementation class, e.g., `PaymentOrderServiceImpl`.

\- `Dao`: Data access class, e.g., `PaymentOrderDao`.

\- `Listener`: Event handler class, e.g., `PaymentSuccessListener`.

\#### 1.4 Method Names

\- Begin with a lowercase letter: `addOrder()`.

\- Use verbs upfront: `addOrder()`, not `orderAdd()`.

Common verb prefixes:

\- `create`, `delete`, `add`, `remove`, `init`, `destroy`, `open`, `close`, `read`, `write`, `get`, `set`, `prepare`, `copy`, `modify`, `calculate`, `do`, `dispatch`, `start`, `stop`, `send`, `receive`, `respond`, `find`, `update`.

\#### 1.5 Field Names

\##### Static Constants

Use uppercase with underscores: `ORDER\_PAID\_EVENT`.

\##### Enumerations

Also uppercase with underscores: `ORDER\_PAID`.

\##### Others

Start with lowercase and use camelCase: `orderName`.

\#### 1.6 Local Variables

Use camelCase, starting with lowercase, and ensure clarity within the method.

\### 2. Code Formatting

Use spaces (4 per level) for indentation.

\#### 2.1 File Encoding

Use UTF-8 encoding with Unix line endings.

\#### 2.2 Line Length

Keep lines under 80 characters.

\#### 2.3 Imports

Remove unused imports and avoid wildcard imports.

\#### 2.4 Field Declaration

Declare one field per line with a blank line between declarations.

\#### 2.5 Method Declaration

\#### 2.6 Code Block Formatting

\##### Indentation

Place opening braces on the same line as the block start.

\##### Spacing

Use single spaces around operators and after commas.

\```java

a + b = c;

call(a, b, c);

\```

\##### Blank Lines

Use blank lines to separate logically distinct sections of code.

\### 3. Comment Guidelines

\#### 3.1 Comments vs. Code

\- Comments should be clear and concise.

\- Avoid excessive or misleading comments.

\- Keep comments in sync with code changes.

\#### 3.2 JavaDoc

Use JavaDoc for classes, fields, and methods to explain usage.

\```java

/\*\*

` `\* Class description

` `\*/

public class ExampleClass {

`    `/\*\*

`     `\* Field description

`     `\*/

`    `public String name;



`    `/\*\*

`     `\* Method description

`     `\*/

`    `public void execute() {

`    `}

}

\```

\#### 3.3 Block Comments

Use `//` for single-line and `/\* ... \*/` for multi-line comments.

\#### 3.4 Inline Comments

Place inline comments at the end of a line using `//`.

\### 4. Best Practices

\#### 4.1 Code Cleanliness

Regularly clean and format your code.

\#### 4.2 Logging

Use logging instead of `System.out.println()`.

\#### 4.3 Braces

Always use braces for `if`, `while`, and `for` statements.

\#### 4.4 TODOs

Utilize TODO comments for pending tasks.

\#### 4.5 Empty Statements

Indicate intentional empty blocks with comments or semicolons.

\#### 4.6 Boolean Comparisons

Avoid comparing boolean values to `true` or `false`.

\#### 4.7 Reduce Nesting

Limit nesting levels to improve readability.

\#### 4.8 Single Responsibility

Ensure each unit of code has a single responsibility.

\#### 4.9 Group Related Code

Keep declaration, initialization, and usage of variables close together.

\---
