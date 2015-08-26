Meta:

Narrative:
輸入漢字，並記錄長度

Scenario: 全漢字的故事
Given 啟動程式
When 加字串 意意
Then 得到長度 2
Then 攏總加 1 擺
When 加字串 傳遞
Then 得到長度 4
Then 攏總加 2 擺
