Meta:

Narrative:
輸入漢字，並記錄長度

Scenario: 長度檢查
Given 啟動程式
When 加字串 意
Then 得到長度 1
When 加字串 傳遞
Then 得到長度 3

Scenario: 空字串
Given 啟動程式
Then 得到長度 0
