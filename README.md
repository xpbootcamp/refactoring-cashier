# 超市收音机

[![Build Status](https://travis-ci.org/xp-bootcamp/refactor-cashier.svg?branch=master)](https://travis-ci.org/xp-bootcamp/refactor-cashier)
 

## 开发环境
 - JDK1.8+

## 需求背景
老王经营了一家超市，之前找了一个Vendor开发了一款简化版的超市收银机。收银机的功能很简单：在顾客结账时，需要打印订单信息。之前的Vendor已经开发出了可以用的代码。


收银机一直都很难用，收银员经常跟老王抱怨。老王由于勤快，把超市做大了，寻思着找个好的Vendor把软件优化一下，并继续开发一些新功能。他听说TW在软件交付方面很擅长，擅长交付高质量的软件，于是找到了TW。

TW工程师接收后，却发现代码存在神一般的命名和谜一般的逻辑，所以为了更好地继续下去，不得已停下来对已有代码进行重构。

此时，你正好在该项目担当重构大任的骨干，接下来请你完成这一轮重构，让代码从`可用`到`简洁可用`。


## 重构过程

### 第一步：构建测试
拿到一份代码，首先要构建，如果已经有测试，运行测试，确保的是是通过的，并通过交叉检查测试是否有效（比如更改断言，看是否会挂掉）。


### 第二步：简单清理
简单清理，动作包括如下：

- 格式化代码，代码缩进，导包
- 删除无用代码，减少噪音高干扰
- 调整代码顺序，让相关的代码更紧凑
- 为复杂逻辑空行，可以按注释分界
- 将类中的属性私有化

### 第三步：开启重构环（闻味道、用手法、验结果）
- Rename Field，`OrderReceipt`类中的字段：`o` -> `order`
- Rename Variable，`OrderReceipt`类中`printReceipt`方法中的：`totSalesTx` -> `totalSalesTax`
- Rename Variable，`OrderReceipt`类中`printReceipt`方法中的：`tot` -> `totalAmountWithTax`
- Rename Field，`Order`类中的字段：`nm` -> `customerName`
- Rename Field，`Order`类中的字段：`addr` -> `address`
- Rename Field，`Order`类中的字段：`li` -> `lineItems`
- Rename Field，`LineItem`类中的字段：`p` -> `price`
- Rename Field，`LineItem`类中的字段：`qty` -> `quantity`
- Rename Field，`LineItem`类中的字段：`desc` -> `description`
- Extract Method，提取计算税额的方法`calculateSalesTax`，消除注释
- Replace Temp with Query，消除掉临时变量`salesTax`
- Move Method，移动计算税额的方法`calculateSalesTax`到`LineItem`类中
- Extract Method，提取计算总额的方法`calculateTotalAmountWithTax`，消除注释
- Move Method，移动计算总额的方法`calculateTotalAmountWithTax`到`LineItem`类中
- Extract Method，提取计算总税额的方法`calculateTotalSalesTax`
- Move Method，移动计算总税额的方法`calculateTotalSalesTax`到`Order`类中
- Extract Method，提取计算总额的方法`calculateTotalAmountWithTax`
- Move Method，移动计算总额的方法`calculateTotalAmountWithTax `到`Order`类中
- Extract Method，提取注明Headers方法`stateHeaders`
- Extract Method，提取注明总税额方法`stateTotalSalesTax`
- Extract Method，提取注明总额方法`stateTotalAmount`
- Extract Method，提取注明客户信息`stateCustomer`
- Extract Method，提取注明订单条目信息的方法`stateLineItem`
- Move Method，移动注明订单条目信息的方法到`stateLineItem`到`LineItem`类中
- Extract Method，提取注明订单订单条目列表信息的方法`stateLineItems`
- Extract Class，提取Customer类，将`Order`中的`customerName`、`customerAddress`移动到`Customer`类中，并重命名字段为`name`和`address`
- Replace Magic Number with Symbolic Constant，将`LineItem`中的`0.1`替换成常量`TAX`
- Rename Method，将`LineItem`类中的`stateLineItem`重命名为`state`
- Rename Method，将`OrderReceipt`类中的`printReceipt`重命名为`generateReceipt`
- Substitute Algorithm，将`Order`中`calculateTotalSalesTax`方法中的For环替换掉
- Substitute Algorithm，将`Order`中`calculateTotalAmount`方法中的For环替换掉
- Move Method，将`OrderReceipt`中的方法`stateLineItems`、`stateCustomer`、`stateStateTax`、`stateTotalAmountWithTax`方法移动到 `Order`类中
- Extract Method，将`OrderReceipt`类中`printReceipt`方法调用`Order`的四行代码，提取出一个方法`generateReceipt`
- Move Method，将`OrderReceipt`类中`generateReceipt`方法移动到`Order`类中
- 私有化`Order`类中的方法`stateLineItems`、`stateCustomer`、`stateStateTax`、`stateTotalAmountWithTax`
- Remove Middle Man，将`Order`类中`getCustomerName`、`getCustomerAddress`、`getLineItems`方法移除，内部直接调用属性
- Remove Middle Man，将`LineItem`类中`getPrice`、`getQuantity`方法移除

























