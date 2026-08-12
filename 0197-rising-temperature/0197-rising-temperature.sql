SELECT 
    w1.id
FROM Weather w1
JOIN Weather w2
on DATEDIFF(w1.recordDate,w2.recordDate)=1
where w1.temperature > w2.temperature