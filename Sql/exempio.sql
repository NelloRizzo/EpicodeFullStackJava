select 
    current_timestamp,
    current_date,
    "numeroFattura" num, 
    "dataFattura" data, 
    extract(year from "dataFattura") anno,
    extract(day from "dataFattura") giorno, 
    extract(month from "dataFattura") mese
FROM epicode.fatture 