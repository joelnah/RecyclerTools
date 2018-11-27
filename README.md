# RecyclerTools

implementation 'com.github.joelnah:RecyclerTools:1.1'



        initData();

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new RecyclerAdapter(this, mDatas);

        recyclerView.setAdapter(adapter);



        recyclerView.setHasFixedSize(true);

        // StaggeredGrid 레이아웃을 사용한다
        //StaggeredGridLayoutManager layoutManager = new WrapContentStaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        GridLayoutManager layoutManager = new WrapContentGridLayoutManager(this, 3);
        //LinearLayoutManager layoutManager = new WrapContentLinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);




        recyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                //call.add(page + 1);
            }
        });



        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Log.d("nah", "Click position"+position);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                    }
                })
        );




    }

    private void initData() {
        mDatas = new ArrayList<>();
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add("TEST" + (char) i);
        }
    }
