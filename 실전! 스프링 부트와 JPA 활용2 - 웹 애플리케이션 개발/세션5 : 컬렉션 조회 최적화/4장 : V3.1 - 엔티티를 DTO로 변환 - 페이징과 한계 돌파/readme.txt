### <목적>
- 페치 조인된 대상을 페이징 가능하게 만드는 것
- 요약
    - properties.yml
        - default_batch_fetch_size: 100
        - 지연 로딩된 객체를 가져올 시, 한 번에 가져올 양을 정하는 것
        - (100 = 지연 로딩 객체 가져올 때, 100개씩 가져옴)

- 설명
    - offset ~ limit 까지의 데이터를 가져옴
    - 해당 repository 함수에는 orderItems가 없으므로, OrderDto에서 orderItems을 가져옴
    - default_batch_fetch_size: 100 이므로, orderItems를 최대 100개 가져옴
    - ⇒ 각 order마다 orderItems를 DB에서 가져오지 않아도 되므로, 성능 최적화가 된 거임

- default_batch_fetch_size의 크기는?
    - 최대 1000(넘어가면 DB에서 에러날 수 있음)
    - DB가 순간 부하를 버틸 수 있을만큼 최대로 늘리면 된다고 함
