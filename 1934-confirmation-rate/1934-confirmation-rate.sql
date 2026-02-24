select s.user_id, 
    round(sum(if(action like 'confirmed', 1, 0)) / sum(if(action like 'confirmed', 1, 1)), 2) as confirmation_rate
from Signups s
left join Confirmations c
on s.user_id = c.user_id
group by user_id